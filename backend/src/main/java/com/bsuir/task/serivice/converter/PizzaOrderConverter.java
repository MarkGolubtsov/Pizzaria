package com.bsuir.task.serivice.converter;

import com.bsuir.task.repository.entity.PizzaOrder;
import com.bsuir.task.serivice.dto.PizzaOrderDto;
import com.bsuir.task.serivice.dto.PizzaOrderFull;

public class PizzaOrderConverter {

    private PizzaOrderConverter() {
    }

    public static PizzaOrder fromDTO(PizzaOrderDto pizzaOrderDto) {
        PizzaOrder orderPizza = new PizzaOrder();
        orderPizza.setId(pizzaOrderDto.getId())
                .setQuantity(pizzaOrderDto.getQuantity());
        return orderPizza;
    }

    public static PizzaOrderDto toDTO(PizzaOrder pizzaOrder) {
        PizzaOrderDto pizzaOrderDto = new PizzaOrderDto();
        pizzaOrderDto
                .setQuantity(pizzaOrder.getQuantity())
                .setId(pizzaOrder.getId());
        return pizzaOrderDto;
    }

    public static PizzaOrderFull toFull(PizzaOrder pizzaOrder) {
        PizzaOrderFull pizzaOrderFull = new PizzaOrderFull();
        pizzaOrderFull
                .setQuantity(pizzaOrder.getQuantity())
                .setPizza(pizzaOrder.getPizza());
        return pizzaOrderFull;
    }
}
