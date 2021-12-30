package com.bsuir.task.serivice.dto;

import java.util.Objects;

public class OrderPizzaDTO extends EntityDTO {

    private long id;

    private PizzaDTO pizzaDTO;

    private OrderDTO orderDTO;

    private Integer quantity;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public OrderPizzaDTO setId(long id) {
        this.id = id;
        return this;
    }

    public PizzaDTO getPizzaDTO() {
        return pizzaDTO;
    }

    public OrderPizzaDTO setPizzaDTO(PizzaDTO pizzaDTO) {
        this.pizzaDTO = pizzaDTO;
        return this;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public OrderPizzaDTO setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderPizzaDTO setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPizzaDTO that = (OrderPizzaDTO) o;
        return id == that.id && pizzaDTO.equals(that.pizzaDTO) && orderDTO.equals(that.orderDTO) && quantity.equals(that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pizzaDTO, orderDTO, quantity);
    }
}
