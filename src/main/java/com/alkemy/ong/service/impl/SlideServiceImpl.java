package com.alkemy.ong.service.impl;

import com.alkemy.ong.domain.entity.SlideEntity;
import com.alkemy.ong.domain.mapper.SlideMapper;
import com.alkemy.ong.domain.request.SlideRequest;
import com.alkemy.ong.domain.response.SlideResponse;
import com.alkemy.ong.exception.ParamNotFound;
import com.alkemy.ong.repository.SlideRepository;
import com.alkemy.ong.service.SlideService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
        Integer order = generateOrder(request.getOrganization());
        entity.setSlideOrder(request.getSlideOrder() != null && request.getSlideOrder() > order
                ? request.getSlideOrder() : order + 1);

        return slideMapper.entity2DtoResponse(slideRepository.save(entity));
    }

    public SlideEntity getById(UUID id){
        return slideRepository.findById(id).orElseThrow(
                () -> new ParamNotFound("Slide not found"));
    }

    public String generateUrlAmazon(MultipartFile imageB64){
        return amazonClient.uploadFile(imageB64);
    }

    public Integer generateOrder(UUID organization){
        Integer order = slideRepository.findMaxSlideOrder(organization);
        return order == null ? 0 : order;
    }

    public SlideResponse getByIdResponse(UUID id){
        return slideMapper.entity2DtoResponse(getById(id));
    }
}
