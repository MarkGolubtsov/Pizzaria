package com.bsuir.task.serivice.converter;

import com.bsuir.task.repository.entity.OrderPizza;
import com.bsuir.task.serivice.dto.OrderPizzaDTO;

public class OrderPizzaConverter {

    private OrderPizzaConverter() {}

    public static OrderPizza fromDTO(OrderPizzaDTO orderPizzaDTO) {
        OrderPizza orderPizza = new OrderPizza();
        orderPizza.setId(orderPizzaDTO.getId())
            .setPizza(PizzaConverter.fromDTO(orderPizzaDTO.getPizzaDTO()))
            .setOrder(OrderConverter.fromDTO(orderPizzaDTO.getOrderDTO()))
            .setQuantity(orderPizzaDTO.getQuantity());
        return orderPizza;
    }

    public static OrderPizzaDTO toDTO(OrderPizza orderPizza) {
        OrderPizzaDTO orderPizzaDTO = new OrderPizzaDTO();
        orderPizzaDTO.setId(orderPizza.getId())
            .setOrderDTO(OrderConverter.toDTO(orderPizza.getOrder()))
            .setPizzaDTO(PizzaConverter.toDTO(orderPizza.getPizza()))
            .setQuantity(orderPizza.getQuantity());
        return orderPizzaDTO;
    }
}
