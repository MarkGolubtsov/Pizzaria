package com.bsuir.task.serivice.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class CreateOrderRequest {

    @NotEmpty
    Set<PizzaOrderDto> pizzaOrders;

    @NotNull
    String contact;

    String comment;

    public Set<PizzaOrderDto> getPizzaOrders() {
        return pizzaOrders;
    }

    public CreateOrderRequest setPizzaOrders(Set<PizzaOrderDto> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
        return this;
    }

    public String getContact() {
        return contact;
    }

    public CreateOrderRequest setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public CreateOrderRequest setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
