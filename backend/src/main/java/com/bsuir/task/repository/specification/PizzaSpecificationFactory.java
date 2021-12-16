package com.bsuir.task.repository.specification;

import com.bsuir.task.repository.entity.Pizza;
import org.springframework.data.jpa.domain.Specification;

public class PizzaSpecificationFactory {

    private PizzaSpecificationFactory() {
    }

    public static Specification<Pizza> getPizzaByLikeName(String name) {
        return getPizzaByLikeStringField("name", name);
    }

    public static Specification<Pizza> getPizzaByLikeDescription(String name) {
        return getPizzaByLikeStringField("description", name);
    }

    private static Specification<Pizza> getPizzaByLikeStringField(String nameField, String value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get(nameField)), getContainsLikePattern(value).toLowerCase());
    }

    private static String getContainsLikePattern(String searchTerm) {
        if (searchTerm == null || searchTerm.isEmpty()) {
            return "%";
        } else {
            return "%" + searchTerm + "%";
        }
    }
}
