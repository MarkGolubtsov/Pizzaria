package com.bsuir.task.serivice.converter;

import com.bsuir.task.repository.entity.Pizza;
import com.bsuir.task.serivice.dto.PizzaDTO;

public class PizzaConverter {

    private PizzaConverter() {
    }

    public static Pizza fromDTO(PizzaDTO pizzaDTO) {
        Pizza pizza = new Pizza();
        pizza.setId(pizzaDTO.getId())
                .setName(pizzaDTO.getName())
                .setDescription(pizzaDTO.getDescription())
                .setPrice(pizzaDTO.getPrice())
                .setWeight(pizzaDTO.getWeight());
        return pizza;
    }

    public static PizzaDTO toDTO(Pizza pizza) {
        PizzaDTO pizzaDTO = new PizzaDTO();
        pizzaDTO.setId(pizza.getId())
                .setName(pizza.getName())
                .setDescription(pizza.getDescription())
                .setPrice(pizza.getPrice())
                .setWeight(pizza.getWeight());
        return pizzaDTO;
    }

}
