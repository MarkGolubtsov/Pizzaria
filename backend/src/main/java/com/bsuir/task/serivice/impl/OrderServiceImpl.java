package com.bsuir.task.serivice.impl;

import com.bsuir.task.repository.OrderRepository;
import com.bsuir.task.repository.PizzaOrderRepository;
import com.bsuir.task.repository.PizzaRepository;
import com.bsuir.task.repository.entity.Order;
import com.bsuir.task.repository.entity.Pizza;
import com.bsuir.task.repository.entity.PizzaOrder;
import com.bsuir.task.repository.specification.OrderSpecificationFactory;
import com.bsuir.task.serivice.OrderService;
import com.bsuir.task.serivice.converter.OrderConverter;
import com.bsuir.task.serivice.dto.CreateOrderRequest;
import com.bsuir.task.serivice.dto.OrderDTO;
import com.bsuir.task.serivice.dto.OrderSearchParameters;
import com.bsuir.task.serivice.dto.SearchParameters;
import com.bsuir.task.serivice.exception.NotFoundEntityException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final String NOT_FOUND_MESSAGE = "Not found order.";

    private final String NOT_FOUND_PIZZA_MESSAGE = "Not found pizza for order.";

    private final OrderRepository repository;

    private final PizzaRepository pizzaRepository;
    private final PizzaOrderRepository pizzaOrderRepository;

    public OrderServiceImpl(OrderRepository repository, PizzaRepository pizzaRepository, PizzaOrderRepository pizzaOrderRepository) {
        this.repository = repository;
        this.pizzaRepository = pizzaRepository;
        this.pizzaOrderRepository = pizzaOrderRepository;
    }

    @Transactional
    public OrderDTO create(CreateOrderRequest entity) {
        LocalDateTime date = LocalDateTime.now();
        Order order = new Order();
        order.setContact(entity.getContact());
        order.setComment(entity.getComment());
        order.setDate(date);
        order.setClosed(false);

        Set<PizzaOrder> pizzaOrder = entity.getPizzaOrders().stream().map(it -> {
            PizzaOrder newPizzaOrder = new PizzaOrder();
            Pizza pizza = pizzaRepository.findById(it.getPizza()).orElseThrow(() -> new NotFoundEntityException(NOT_FOUND_PIZZA_MESSAGE));
            newPizzaOrder.setPizza(pizza);
            newPizzaOrder.setQuantity(it.getQuantity());
            newPizzaOrder.setOrder(order);
            return newPizzaOrder;
        }).collect(Collectors.toSet());

        order.setPizzaOrders(pizzaOrder);

        Double amount = order.getPizzaOrders().stream().map((it) -> it.getPizza().getPrice() * it.getQuantity()).reduce((double) 0, Double::sum);
        order.setAmount(amount);
        Order saved = repository.save(order);
        return OrderConverter.toDTO(saved);
    }

    public OrderDTO closeOrder(Long orderId) {
        Order order = repository.findById(orderId).orElseThrow(() -> new NotFoundEntityException(NOT_FOUND_PIZZA_MESSAGE));
        order.setClosed(true);
        repository.save(order);
        return OrderConverter.toDTO(order);
    }


    @Override
    public OrderDTO create(OrderDTO entity) {
        throw new NotImplementedException();
    }

    @Override
    public Page<OrderDTO> readAll(SearchParameters parameters) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Page<OrderDTO> readAll(OrderSearchParameters parameters) {
        Pageable paging = PageRequest.of(parameters.getPage(), parameters.getPageSize(), Sort.by("date").descending());
        Specification<Order> specification = builtSpecification(parameters);
        Page<Order> pagedResult = repository.findAll(specification, paging);
        return pagedResult.map(OrderConverter::toDTO);
    }

    @Override
    public OrderDTO read(long id) {
        Order order = repository.findById(id).orElseThrow(() -> new NotFoundEntityException(NOT_FOUND_MESSAGE));
        return OrderConverter.toDTO(order);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public OrderDTO update(OrderDTO entity) {
        return null;
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
