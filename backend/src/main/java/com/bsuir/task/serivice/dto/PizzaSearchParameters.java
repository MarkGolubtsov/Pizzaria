package com.bsuir.task.serivice.dto;

public class PizzaSearchParameters extends SearchParameters {
    public String sortProperty = "id";

    public String sortType = "asc";

    public String getSortProperty() {
        return sortProperty;
    }

    public PizzaSearchParameters setSortProperty(String sortProperty) {
        this.sortProperty = sortProperty;
        return this;
    }

    public String getSortType() {
        return sortType;
    }

    public PizzaSearchParameters setSortType(String sortType) {
        this.sortType = sortType;
        return this;
    }
}
