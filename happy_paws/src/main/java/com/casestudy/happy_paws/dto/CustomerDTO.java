package com.casestudy.happy_paws.dto;

import com.casestudy.happy_paws.model.Account;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


public class CustomerDTO implements Validator {


    private Integer customerId;


    @Size(max = 100, message = "name cannot be longer than 100 characters")
    @Pattern(regexp = "^([A-Z])([a-z])*((\\s)[A-Z]([a-z]*)){0,4}$", message = "malformed name")
    private String name;

    @Size(max = 11, message = "Phone number cannot 11 number !!!")
    @Pattern(regexp = "^0[0-9]{9,10}$", message = "Invalid phone number")

    private String phone;
    @Email
    private String email;

    @Size(max = 100, message = "Address cannot longer than 100 character !!")
    private String address;

    private Account account;
    @Column(name = "create_time", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private LocalDateTime createTime;

    @Column(name = "update_time", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private LocalDateTime updateTime;

    public CustomerDTO(Integer customerId, String name, String phone, String email, String address, Account account, LocalDateTime createTime, LocalDateTime updateTime) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.account = account;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public CustomerDTO(String name, String phone, String email, String address, Account account, LocalDateTime createTime, LocalDateTime updateTime) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.account = account;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public CustomerDTO() {
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
