package com.casestudy.happy_paws.dto;

import com.casestudy.happy_paws.model.Role;

import javax.persistence.*;
import javax.validation.constraints.Size;

public class AccountDTO {

    private Integer accountId;


    @Size(max = 100 , message = "username cannot longer than 100 character !!!")
    private String username;
    @Size(max = 100 , message = "username cannot longer than 100 character !!!")
    private String password;

    @OneToOne(mappedBy = "role")
    private Role role; // dat ten cung khong giong nhau nua

    public AccountDTO(Integer accountId, String username, String password, Role role) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public AccountDTO(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public AccountDTO() {
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
