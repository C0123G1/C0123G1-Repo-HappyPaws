package com.casestudy.happy_paws.dto;

import com.casestudy.happy_paws.model.Account;

import java.time.LocalDateTime;

public class EmployeeDTO {
    private Long employeeId;
    private String name;
    private String phone;
    private String email;
    private String address;

    private Account account;

    private LocalDateTime dateCreate;

    private LocalDateTime dateUpdate;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long employeeId, String name, String phone, String email, String address, Account account, LocalDateTime dateCreate, LocalDateTime dateUpdate) {
        this.employeeId = employeeId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.account = account;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public EmployeeDTO(String name, String phone, String email, String address, Account account) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.account = account;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
