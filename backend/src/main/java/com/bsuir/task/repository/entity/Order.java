package com.bsuir.task.repository.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "base_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date")
    private Date date;

    @Column(name = "isClosed")
    private Boolean isClosed;

    @Column(name = "amount")
    private Double amount;

    public long getId() {
        return id;
    }

    public Order setId(long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Order setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Order setDate(Date date) {
        this.date = date;
        return this;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public Order setClosed(Boolean closed) {
        isClosed = closed;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Order setAmount(Double amount) {
        this.amount = amount;
        return this;
    }
}
