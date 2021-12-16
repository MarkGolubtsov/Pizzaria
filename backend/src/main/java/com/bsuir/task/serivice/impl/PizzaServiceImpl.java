package com.bsuir.task.serivice.impl;

import com.bsuir.task.repository.PizzaRepository;
import com.bsuir.task.repository.entity.Order;
import com.bsuir.task.repository.entity.Pizza;
import com.bsuir.task.repository.specification.PizzaSpecificationFactory;
import com.bsuir.task.serivice.PizzaService;
import com.bsuir.task.serivice.converter.OrderConverter;
import com.bsuir.task.serivice.converter.PizzaConverter;
import com.bsuir.task.serivice.dto.PizzaDTO;
import com.bsuir.task.serivice.dto.SearchParameters;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository repository;

    public PizzaServiceImpl(PizzaRepository repository) {
        this.repository = repository;
    }

    @Override
    public PizzaDTO create(PizzaDTO entity) {
        Pizza saved = repository.save(PizzaConverter.fromDTO(entity));
        return PizzaConverter.toDTO(saved);
    }

    @Override
    public Page<PizzaDTO> readAll(SearchParameters parameters) {
        Pageable paging = PageRequest.of(parameters.getPage(), parameters.getPageSize(), Sort.by("id"));
        Specification<Pizza> specification = builtSpecification(parameters);
        Page<Pizza> pagedResult = repository.findAll(specification, paging);
        return pagedResult.map(PizzaConverter::toDTO);
    }

    @Override
    public PizzaDTO read(long id) {
        Optional<Pizza> optionalPizza = repository.findById(id);
        if (optionalPizza.isPresent()) {
            return PizzaConverter.toDTO(optionalPizza.get());
        } else {
            throw new RuntimeException("not found");
        }
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public PizzaDTO update(PizzaDTO entity) {
        Pizza updated = repository.save(PizzaConverter.fromDTO(entity));
        return PizzaConverter.toDTO(updated);
    }

    private Specification<Pizza> builtSpecification(SearchParameters parameters) {
        String text = parameters.getText();
        Specification<Pizza> specification = (root, query, criteriaBuilder) -> criteriaBuilder.isNotNull(root.get(
                "id"
        ));

        if (!StringUtils.isEmpty(text)) {
            specification = specification.and(PizzaSpecificationFactory.getPizzaByLikeName(text)
                    .or(PizzaSpecificationFactory.getPizzaByLikeDescription(text)));
        }
        return specification;
    }
}