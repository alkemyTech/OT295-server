package com.alkemy.ong.repository.Specifications;

import com.alkemy.ong.domain.entity.CommentEntity;
import com.alkemy.ong.domain.request.CommentRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommentsSpecifications {

    public Specification<CommentEntity> getByDate(CommentRequest comment) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicateList = new ArrayList<>();

            // remove duplicated
            query.distinct(true);


            String orderByField = "timestamp";
            query.orderBy(
                    comment.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicateList.toArray(predicateList.toArray(new Predicate[0])));
        };
    }
}
