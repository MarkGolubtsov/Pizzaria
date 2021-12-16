package com.bsuir.task.serivice;

import com.bsuir.task.serivice.dto.OrderDTO;
import com.bsuir.task.serivice.dto.OrderSearchParameters;
import com.bsuir.task.serivice.dto.PizzaDTO;
import com.bsuir.task.serivice.dto.PizzaSearchParameters;
import org.springframework.data.domain.Page;

public interface PizzaService extends Service<PizzaDTO> {

    Page<PizzaDTO> readAll(PizzaSearchParameters parameters);

}
