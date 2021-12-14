package com.bsuir.task.repository;

import com.bsuir.task.repository.entity.Order;
import com.bsuir.task.repository.entity.OrderPizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderPizzaRepository extends JpaRepository<OrderPizza, Long>, JpaSpecificationExecutor<Order> {
}
