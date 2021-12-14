package com.bsuir.task.serivice.dto;

import java.util.Date;
import java.util.Objects;

public class OrderDTO extends EntityDTO {

    private long id;

    private String comment;

    private UserDTO userDTO;

    private Date date;

    private Boolean isClosed;

    private Double amount;

    public long getId() {
        return id;
    }

    public OrderDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public OrderDTO setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public OrderDTO setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public OrderDTO setDate(Date date) {
        this.date = date;
        return this;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public OrderDTO setClosed(Boolean closed) {
        isClosed = closed;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public OrderDTO setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return id == orderDTO.id && comment.equals(orderDTO.comment) && userDTO.equals(orderDTO.userDTO) && date.equals(orderDTO.date) && isClosed.equals(orderDTO.isClosed) && amount.equals(orderDTO.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment, userDTO, date, isClosed, amount);
    }
}
