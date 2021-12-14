package com.bsuir.task.serivice;

import com.bsuir.task.serivice.dto.OrderDTO;
import com.bsuir.task.serivice.dto.PizzaSearchParameters;
import org.springframework.data.domain.Page;

public interface OrderService extends Service<OrderDTO> {

    Page<OrderDTO> readAll(PizzaSearchParameters parameters);
}
