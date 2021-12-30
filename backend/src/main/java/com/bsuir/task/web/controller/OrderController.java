package com.bsuir.task.web.controller;

import com.bsuir.task.serivice.OrderPizzaService;
import com.bsuir.task.serivice.OrderService;
import com.bsuir.task.serivice.dto.*;
import com.bsuir.task.serivice.exception.NotFoundEntityException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService service;
    private final OrderPizzaService orderPizzaService;

    public OrderController(OrderService service, OrderPizzaService orderPizzaService) {
        this.service = service;
        this.orderPizzaService = orderPizzaService;
    }

//    @PreAuthorize("hasAnyRole('VIEWER','ADMIN')")
    @GetMapping
    public Page<OrderDTO> read(@Valid OrderSearchParameters paramsSearch) {
        return service.readAll(paramsSearch);
    }

    @PostMapping()
    public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO newOrderDTO) {
        OrderDTO order = service.create(newOrderDTO);

        if (order == null) {
            throw new NotFoundEntityException("Not found");
        } else {
            return new ResponseEntity<>(order, HttpStatus.CREATED);
        }
    }

    @PutMapping()
    public OrderDTO update(@RequestBody OrderDTO orderDTO) {
        return service.update(orderDTO);
    }

    @DeleteMapping()
    public ResponseEntity<Long> delete(@PathVariable Long orderId) {
        service.delete(orderId);
        return new ResponseEntity<>(orderId, HttpStatus.OK);
    }

}
