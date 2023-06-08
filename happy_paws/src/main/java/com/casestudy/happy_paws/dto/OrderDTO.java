package com.casestudy.happy_paws.dto;

import com.casestudy.happy_paws.model.Customer;
import com.casestudy.happy_paws.model.OrderDetail;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class OrderDTO {
    private Long id;
    private Customer customer;

    private LocalDateTime buyDate;

    public OrderDTO() {
    }

    public OrderDTO(Long id, Customer customer, LocalDateTime buyDate) {
        this.id = id;
        this.customer = customer;

        this.buyDate = buyDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public LocalDateTime getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(LocalDateTime buyDate) {
        this.buyDate = buyDate;
    }
}
