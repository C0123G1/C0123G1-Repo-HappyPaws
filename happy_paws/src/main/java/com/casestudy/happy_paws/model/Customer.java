package com.casestudy.happy_paws.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;
    @Column(name = "phone", nullable = false, columnDefinition = "VARCHAR(10)")
    private String phone;
    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(100)")
    private String email;
    @Column(name = "address", nullable = false, columnDefinition = "VARCHAR(100)")
    private String address;
    @ManyToOne
    @JoinColumn
    private User user;


    @Column(name = "create_time" ,updatable = false,nullable = false,columnDefinition ="TIMESTAMP DEFAULT now()" )
    @CreationTimestamp
    private LocalDateTime createTime ;
    @Column(name = "update_time",nullable = false,updatable = false,columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private  LocalDateTime updateTime ;

    public Customer(Integer customerId, String name, String phone, String email, String address, User user, LocalDateTime createTime, LocalDateTime updateTime) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.user = user;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Customer() {
    }

    public Customer(String name, String phone, String email, String address, User user, LocalDateTime createTime, LocalDateTime updateTime) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.user = user;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
