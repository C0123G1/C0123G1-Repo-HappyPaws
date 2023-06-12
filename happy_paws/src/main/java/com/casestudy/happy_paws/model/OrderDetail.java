package com.casestudy.happy_paws.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productsId;
    @ManyToOne
    @JoinColumn
    private Orders order;
    private Integer quantity;
    private Double price;
    @Column(nullable = false,updatable = false,columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private LocalDateTime createDate;
    @Column(nullable = false,columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private LocalDateTime updateDate;

    public OrderDetail() {
    }

    public OrderDetail(Long id, Long productsId, Orders order, Integer quantity, Double price, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.productsId = productsId;
        this.order = order;
        this.quantity = quantity;
        this.price = price;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductsId() {
        return productsId;
    }

    public void setProductsId(Long productsId) {
        this.productsId = productsId;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
