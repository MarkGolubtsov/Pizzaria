package com.bsuir.task.serivice.dto;


public class PizzaOrderDto extends EntityDTO {

    private Long pizza;

    private Integer quantity;

    public Long getPizza() {
        return pizza;
    }

    public PizzaOrderDto setPizza(Long pizza) {
        this.pizza = pizza;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public PizzaOrderDto setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }


}
