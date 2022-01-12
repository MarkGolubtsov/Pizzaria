package com.bsuir.task.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "visible")
    private boolean visible;

    public boolean isVisible() {
        return visible;
    }

    public Pizza setVisible(boolean visible) {
        this.visible = visible;
        return this;
    }

    public long getId() {
        return id;
    }

    public Pizza setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Pizza setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Pizza setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Pizza setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public Pizza setWeight(Double weight) {
        this.weight = weight;
        return this;
    }
}
