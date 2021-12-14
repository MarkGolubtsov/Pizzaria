package com.bsuir.task.repository.specification;

import com.bsuir.task.repository.entity.Order;
import org.springframework.data.jpa.domain.Specification;

public class OrderSpecificationFactory {

    private OrderSpecificationFactory() {}

    public static Specification<Order> getOrderByStatus(Boolean isClosed) {
        return getOrderByLikeBooleanField("isClosed", isClosed);
    }

    private static Specification<Order> getOrderByLikeBooleanField(String nameField, Boolean value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(criteriaBuilder.lower(root.get(nameField)), value);
    }

}
