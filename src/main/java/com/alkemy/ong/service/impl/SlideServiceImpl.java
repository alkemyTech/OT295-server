package com.alkemy.ong.service.impl;

import com.alkemy.ong.domain.dto.SlideDTOImageOrder;
import com.alkemy.ong.domain.entity.SlideEntity;
import com.alkemy.ong.domain.mapper.SlideMapper;
import com.alkemy.ong.domain.request.SlideRequest;
import com.alkemy.ong.domain.response.SlideResponse;
import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.exception.ParamNotFound;
import com.alkemy.ong.repository.SlideRepository;
import com.alkemy.ong.service.SlideService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SlideServiceImpl implements SlideService {

    private final SlideRepository slideRepository;
    private final AmazonClient amazonClient;
    private final SlideMapper slideMapper;

    @Override
    public SlideResponse saveSlide(SlideRequest request) {
        SlideEntity entity = slideMapper.DTO2Entity(request);
        entity.setImageUrl(generateUrlAmazon(request.getImage_b64()));
        entity.setText(request.getText());
        /*
        Integer order = generateOrder(request.getOrganization());
        entity.setSlideOrder(request.getSlideOrder() != null && request.getSlideOrder() > order
                ? request.getSlideOrder() : order + 1);
        */
        return slideMapper.entity2DtoResponse(slideRepository.save(entity));
    }

    public SlideEntity getById(UUID id) {
        return slideRepository.findById(id).orElseThrow(
                () -> new ParamNotFound("Slide not found"));
    }

    public String generateUrlAmazon(String imageB64) {

        return amazonClient.uploadFile(imageB64, UUID.randomUUID().toString());
    }

    public Integer generateOrder(UUID organization) {
        Integer order = slideRepository.findMaxSlideOrder(organization);
        return order == null ? 0 : order;
    }

    public SlideResponse getByIdResponse(UUID id) {
        return slideMapper.entity2DtoResponse(getById(id));
    }

    @Override
    public List<SlideDTOImageOrder> readAllSlides() {
        List<SlideDTOImageOrder> slideDTOImageOrderList = new ArrayList<>();
        List<SlideEntity> slideEntityList = slideRepository.findAll();


        for (SlideEntity slide : slideEntityList) {
            slideDTOImageOrderList.add(slideMapper.entity2DTOImageOrder(slide));
        }

        return slideDTOImageOrderList;
    }

    @Override
    public SlideResponse update(UUID id, SlideRequest request) {
        Optional<SlideEntity> entity= slideRepository.findById(id);
        if (entity.isEmpty()){
            throw new NotFoundException("Slide not exist");
        }
        SlideEntity slide= entity.get();
        slide.setText(request.getText());
        slide.setImageUrl(request.getImage_b64());
        return slideMapper.entity2DtoResponse(slideRepository.save(slide));
    }

    @Override
    public void delete(UUID id) {

        if (!slideRepository.existsById(id)) {
            throw new NotFoundException("Slide not exist");
        }
        slideRepository.delete(slideRepository.findById(id).get());

    }


}
