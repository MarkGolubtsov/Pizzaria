package com.bsuir.task.web.controller;

import com.bsuir.task.repository.entity.Pizza;
import com.bsuir.task.serivice.PizzaService;
import com.bsuir.task.serivice.dto.PizzaDTO;
import com.bsuir.task.serivice.dto.PizzaSearchParameters;
import com.bsuir.task.serivice.dto.SearchParameters;
import com.bsuir.task.serivice.exception.NotFoundEntityException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.rmi.ServerException;

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

    @PostMapping
    public ResponseEntity<PizzaDTO> create(@RequestBody PizzaDTO newPizzaDTO) {
        PizzaDTO pizza = service.create(newPizzaDTO);
        if (pizza == null) {
            throw new NotFoundEntityException("Not found");
        } else {
            return new ResponseEntity<>(pizza, HttpStatus.CREATED);
        }
    }

    @PutMapping()
    public PizzaDTO update(@RequestBody PizzaDTO pizzaDTO) {
        return service.update(pizzaDTO);
    }

    @DeleteMapping("/{pizzaId}")
    public ResponseEntity<Long> delete(@PathVariable Long pizzaId) {
        service.delete(pizzaId);
        return new ResponseEntity<>(pizzaId, HttpStatus.OK);
    }

}
