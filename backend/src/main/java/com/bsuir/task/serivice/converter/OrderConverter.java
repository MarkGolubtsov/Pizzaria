package com.bsuir.task.serivice.converter;

import com.bsuir.task.repository.entity.Order;
import com.bsuir.task.serivice.dto.OrderDTO;

import java.util.stream.Collectors;

public class OrderConverter {

    private OrderConverter() {
    }

    public static OrderDTO toDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId())
                .setAmount(order.getAmount())
                .setClosed(order.getClosed())
                .setContact(order.getContact())
                .setComment(order.getComment())
                .setPizzaOrders(order.getPizzaOrders().stream().map(PizzaOrderConverter::toFull).collect(Collectors.toSet()))
                .setDate(order.getDate());
        return orderDTO;
    }
}
