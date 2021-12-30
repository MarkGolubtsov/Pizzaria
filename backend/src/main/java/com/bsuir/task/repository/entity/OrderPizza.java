package com.bsuir.task.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_pizza")
public class OrderPizza {

    @Column(name = "quantity")
    private Integer quantity;

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pizza_id", nullable = false)
    private Pizza pizza;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public OrderPizza setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderPizza setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public OrderPizza setPizza(Pizza pizza) {
        this.pizza = pizza;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public OrderPizza setOrder(Order order) {
        this.order = order;
        return this;
    }
}
