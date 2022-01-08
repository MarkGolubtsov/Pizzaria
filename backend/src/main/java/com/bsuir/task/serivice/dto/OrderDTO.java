package com.bsuir.task.serivice.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class OrderDTO extends EntityDTO {

    private long id;

    private String comment;

    private String contact;

    private String date;

    private Boolean isClosed;

    private Double amount;

    private Set<PizzaOrderFull> pizzaOrders;

    public Set<PizzaOrderFull> getPizzaOrders() {
        return pizzaOrders;
    }

    public OrderDTO setPizzaOrders(Set<PizzaOrderFull> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
        return this;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public OrderDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public OrderDTO setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public String getContact() {
        return contact;
    }

    public OrderDTO setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public String getDate() {
        return date;
    }

    public OrderDTO setDate(LocalDateTime date) {
        this.date = date.toString();
        return this;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public OrderDTO setClosed(Boolean closed) {
        isClosed = closed;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public OrderDTO setAmount(Double amount) {
        this.amount = amount;
        return this;
    }
}
