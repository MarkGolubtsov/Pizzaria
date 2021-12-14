package com.bsuir.task.serivice.converter;

import com.bsuir.task.repository.entity.Order;
import com.bsuir.task.repository.entity.Pizza;
import com.bsuir.task.serivice.dto.OrderDTO;
import com.bsuir.task.serivice.dto.PizzaDTO;
import com.bsuir.task.serivice.dto.UserConverter;

public class OrderConverter {

    private OrderConverter() {}

    public static Order fromDTO(OrderDTO orderDTO) {
        com.bsuir.task.repository.entity.Order order = new Order();
        order.setId(orderDTO.getId())
                .setAmount(orderDTO.getAmount())
                .setClosed(orderDTO.getClosed())
                .setComment(orderDTO.getComment())
                .setDate(orderDTO.getDate())
                .setUser(UserConverter.fromDTO(orderDTO.getUserDTO()));
        return order;
    }

    public static OrderDTO toDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(orderDTO.getId())
                .setAmount(orderDTO.getAmount())
                .setClosed(order.getClosed())
                .setComment(order.getComment())
                .setDate(order.getDate())
                .setUserDTO(UserConverter.toDTO(order.getUser()));
        return orderDTO;
    }
}
