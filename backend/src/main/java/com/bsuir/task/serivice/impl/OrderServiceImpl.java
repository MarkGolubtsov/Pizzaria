package com.bsuir.task.serivice.impl;

import com.bsuir.task.repository.OrderRepository;
import com.bsuir.task.repository.entity.Order;
import com.bsuir.task.repository.specification.OrderSpecificationFactory;
import com.bsuir.task.serivice.OrderService;
import com.bsuir.task.serivice.converter.OrderConverter;
import com.bsuir.task.serivice.dto.OrderDTO;
import com.bsuir.task.serivice.dto.OrderSearchParameters;
import com.bsuir.task.serivice.dto.PizzaSearchParameters;
import com.bsuir.task.serivice.dto.SearchParameters;
import com.bsuir.task.serivice.exception.NotFoundEntityException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final String NOT_FOUND_MESSAGE = "Not found order.";

    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderDTO create(OrderDTO entity) {
        Order saved = repository.save(OrderConverter.fromDTO(entity));
        return OrderConverter.toDTO(saved);
    }

    @Override
    public Page<OrderDTO> readAll(SearchParameters parameters) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Page<OrderDTO> readAll(OrderSearchParameters parameters) {
        Pageable paging = PageRequest.of(parameters.getPage(), parameters.getPageSize(), Sort.by("id"));
        Specification<Order> specification = builtSpecification(parameters);
        Page<Order> pagedResult = repository.findAll(specification, paging);
        return pagedResult.map(OrderConverter::toDTO);
    }

    @Override
    public OrderDTO read(long id) {
        Optional<Order> optionalOrder = repository.findById(id);
        if (optionalOrder.isPresent()) {
            return OrderConverter.toDTO(optionalOrder.get());
        } else {
            throw new NotFoundEntityException(NOT_FOUND_MESSAGE);
        }
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public OrderDTO update(OrderDTO entity) {
        Order updated = repository.save(OrderConverter.fromDTO(entity));
        return OrderConverter.toDTO(updated);
    }

    private Specification<Order> builtSpecification(OrderSearchParameters parameters) {
        Specification<Order> specification = (root, query, criteriaBuilder) -> criteriaBuilder.isNotNull(root.get(
                "id"
        ));

        if (parameters.isClosed()) {
            specification = specification.and(OrderSpecificationFactory.getOrderByStatus(parameters.isClosed()));
        }

        if (parameters.getDateStart() != null && parameters.getDateEnd() != null) {
            specification = specification.and(OrderSpecificationFactory.getOrderByTimeRange(
                    parameters.getDateStart(), parameters.getDateEnd()
            ));
        }

        return specification;
    }
}
