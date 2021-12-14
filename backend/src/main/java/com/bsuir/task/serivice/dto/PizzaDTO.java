package com.bsuir.task.serivice.dto;

import java.util.Objects;

public class PizzaDTO extends EntityDTO {

    private long id;

    private String name;

    private String description;

    private Double price;

    private Double weight;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public PizzaDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PizzaDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PizzaDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public PizzaDTO setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public PizzaDTO setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PizzaDTO pizzaDTO = (PizzaDTO) o;
        return id == pizzaDTO.id && name.equals(pizzaDTO.name) && description.equals(pizzaDTO.description) && price.equals(pizzaDTO.price) && weight.equals(pizzaDTO.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, weight);
    }

    //    @NotNull(message = "Please provide a name")
//    @Length(max = 30, message = "Please, provide shorter(less 30 symbols) a name.")
//    private String name;
//
//    @NotNull(message = "Please provide  a model")
//    @Length(max = 15, message = "Please, provide shorter(less 15 symbols) a model.")
//    private String model;
//
//
//    @Length(max = 40, message = "Please, provide shorter(less 40 symbols) a location.")
//    private String location;
//
//    @Length(max = 200, message = "Please, provide shorter(less 200 symbols) a description.")
//    private String description;

}
