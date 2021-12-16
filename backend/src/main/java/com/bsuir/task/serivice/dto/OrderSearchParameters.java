package com.bsuir.task.serivice.dto;

import java.time.LocalDateTime;

public class OrderSearchParameters extends SearchParameters {
    boolean isClosed;
    LocalDateTime dateStart;
    LocalDateTime dateEnd;

    public boolean isClosed() {
        return isClosed;
    }

    public OrderSearchParameters setClosed(boolean closed) {
        isClosed = closed;
        return this;
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
}
