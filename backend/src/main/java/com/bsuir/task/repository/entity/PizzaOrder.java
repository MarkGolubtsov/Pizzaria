package com.bsuir.task.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "pizza_order")
public class PizzaOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pizza_id", nullable = false)
    private Pizza pizza;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", nullable = false)
    private Order baseOrder;

    public Long getId() {
        return id;
    }

    public PizzaOrder setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public PizzaOrder setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public PizzaOrder setPizza(Pizza pizza) {
        this.pizza = pizza;
        return this;
    }

    public Order getOrder() {
        return baseOrder;
    }

    public PizzaOrder setOrder(Order order) {
        this.baseOrder = order;
        return this;
    }
}
