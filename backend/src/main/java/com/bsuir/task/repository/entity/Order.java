package com.bsuir.task.repository.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "base_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "contact")
    private String contact;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "isClosed")
    private Boolean isClosed;

    @Column(name = "amount")
    private Double amount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baseOrder")
    private Set<PizzaOrder> pizzaOrders;

    public Set<PizzaOrder> getPizzaOrders() {
        return pizzaOrders;
    }

    public Order setPizzaOrders(Set<PizzaOrder> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
        return this;
    }

    public long getId() {
        return id;
    }

    public Order setId(long id) {
        this.id = id;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Order setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Order setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public Order setClosed(Boolean closed) {
        isClosed = closed;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Order setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public String getContact() {
        return contact;
    }

    public Order setContact(String contact) {
        this.contact = contact;
        return this;
    }
}
