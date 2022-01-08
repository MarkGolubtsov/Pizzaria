package com.bsuir.task.repository;

import com.bsuir.task.repository.entity.Order;
import com.bsuir.task.repository.entity.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Long>, JpaSpecificationExecutor<Order> {
}
