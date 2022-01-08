package com.bsuir.task.serivice.dto;

import com.bsuir.task.repository.entity.Pizza;

public class PizzaOrderFull {

    private Pizza pizza;

    private Integer quantity;

    public Pizza getPizza() {
        return pizza;
    }

    public PizzaOrderFull setPizza(Pizza pizza) {
        this.pizza = pizza;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public PizzaOrderFull setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
