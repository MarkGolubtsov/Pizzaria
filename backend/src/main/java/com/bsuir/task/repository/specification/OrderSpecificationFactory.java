package com.bsuir.task.repository.specification;

import com.bsuir.task.repository.entity.Order;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class OrderSpecificationFactory {

    private OrderSpecificationFactory() {}

    public static Specification<Order> getOrderByStatus(Boolean isClosed) {
        return getOrderByIsClosedField("isClosed", isClosed);
    }

    public static Specification<Order> getOrderByTimeRange(LocalDateTime startDate, LocalDateTime endDate) {
        return getOrderByDateField("date", startDate, endDate);
    }

    private static Specification<Order> getOrderByIsClosedField(String nameField, Boolean value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(criteriaBuilder.lower(root.get(nameField)), value);
    }

    private static Specification<Order> getOrderByDateField(String nameField, LocalDateTime startDate, LocalDateTime endDate) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(nameField), startDate, endDate);
    }

}
