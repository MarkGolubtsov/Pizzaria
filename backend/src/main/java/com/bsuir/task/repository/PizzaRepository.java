package com.bsuir.task.repository;

import com.bsuir.task.repository.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PizzaRepository extends JpaRepository<Pizza, Long>, JpaSpecificationExecutor<Pizza> {
}
