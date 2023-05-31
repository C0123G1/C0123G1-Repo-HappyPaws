package com.casestudy.happy_paws.model;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId ;

    @Column(name = "username",nullable = false,unique = true,columnDefinition = "VARCHAR(100)")
    private String username ;
    @Column(name = "password",nullable = false,columnDefinition = "VARCHAR(100)")
    private String password ;

    @OneToOne
    private Role role;

    public Account(Integer accountId, String username, String password, Role roleId) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.role = roleId;
    }

    public Account(String username, String password, Role roleId) {
        this.username = username;
        this.password = password;
        this.role = roleId;
    }

    public Account() {
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
