package com.bsuir.task.web.controller;

import com.bsuir.task.serivice.OrderService;
import com.bsuir.task.serivice.dto.OrderDTO;
import com.bsuir.task.serivice.dto.SearchParameters;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

//    @PreAuthorize("hasAnyRole('VIEWER','ADMIN')")
    @GetMapping
    public Page<OrderDTO> read(@Valid SearchParameters paramsSearch) {
        return service.readAll(paramsSearch);
    }

}
