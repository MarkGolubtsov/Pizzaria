package com.bsuir.task.web.controller;

import com.bsuir.task.serivice.dto.CreateOrderRequest;
import com.bsuir.task.serivice.dto.OrderDTO;
import com.bsuir.task.serivice.dto.OrderSearchParameters;
import com.bsuir.task.serivice.impl.OrderServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderServiceImpl service;

    public OrderController(OrderServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public Page<OrderDTO> read(@Valid OrderSearchParameters paramsSearch) {
        return service.readAll(paramsSearch);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> create(@RequestBody CreateOrderRequest createOrderRequest) {
        return ResponseEntity.ok(service.create(createOrderRequest));
    }

    @PutMapping
    public OrderDTO update(@RequestBody OrderDTO orderDTO) {
        return service.update(orderDTO);
    }

    @PutMapping("/{id}/close")
    public ResponseEntity<OrderDTO> closeOrder(@PathVariable Long id) {
        return ResponseEntity.ok(service.closeOrder(id));
    }

}
