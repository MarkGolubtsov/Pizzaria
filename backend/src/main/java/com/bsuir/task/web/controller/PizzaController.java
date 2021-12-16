package com.bsuir.task.web.controller;

import com.bsuir.task.serivice.PizzaService;
import com.bsuir.task.serivice.dto.PizzaDTO;
import com.bsuir.task.serivice.dto.PizzaSearchParameters;
import com.bsuir.task.serivice.dto.SearchParameters;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    private final PizzaService service;

    public PizzaController(PizzaService service) {
        this.service = service;
    }

//    @PreAuthorize("hasAnyRole('VIEWER','ADMIN')")
    @GetMapping
    public Page<PizzaDTO> read(@Valid PizzaSearchParameters paramsSearch) {
        return service.readAll(paramsSearch);
    }

}
