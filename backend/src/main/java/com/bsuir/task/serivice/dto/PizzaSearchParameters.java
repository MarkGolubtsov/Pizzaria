package com.bsuir.task.serivice.dto;

import java.time.LocalDateTime;

public class PizzaSearchParameters extends SearchParameters {
    boolean checkedPizza = false;

    LocalDateTime dateStart = LocalDateTime.now();

    LocalDateTime dateEnd = LocalDateTime.now();

    public boolean isCheckedPizza() {
        return checkedPizza;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setCheckedPizza(boolean checkedPizza) {
        this.checkedPizza = checkedPizza;
    }
}
