package com.bsuir.task.serivice.dto;

public class PizzaSearchParameters extends SearchParameters {
    String text;
    String sortProperty;
    String sortType;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public PizzaSearchParameters setText(String text) {
        this.text = text;
        return this;
    }

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
