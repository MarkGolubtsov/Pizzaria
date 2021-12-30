package com.bsuir.task.serivice.impl;

import com.bsuir.task.repository.OrderPizzaRepository;
import com.bsuir.task.repository.entity.OrderPizza;
import com.bsuir.task.serivice.OrderPizzaService;
import com.bsuir.task.serivice.converter.OrderPizzaConverter;
import com.bsuir.task.serivice.dto.OrderPizzaDTO;
import com.bsuir.task.serivice.dto.SearchParameters;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class OrderPizzaServiceImpl implements OrderPizzaService {

    private final OrderPizzaRepository repository;

    public OrderPizzaServiceImpl(OrderPizzaRepository repository) {
        this.repository = repository;
    }


    @Override
    public OrderPizzaDTO create(OrderPizzaDTO entity) {
        OrderPizza saved = repository.save(OrderPizzaConverter.fromDTO(entity));
        return OrderPizzaConverter.toDTO(saved);
    }

    @Override
    public Page<OrderPizzaDTO> readAll(SearchParameters parameters) {
        return null;
    }

    @Override
    public OrderPizzaDTO read(long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public OrderPizzaDTO update(OrderPizzaDTO entity) {
        return null;
    }
}
