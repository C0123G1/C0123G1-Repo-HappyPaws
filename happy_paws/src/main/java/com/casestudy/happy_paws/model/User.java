package com.casestudy.happy_paws.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UserId;

    @Column(name = "username",nullable = false,unique = true,columnDefinition = "VARCHAR(100)")
    private String username ;
    @Column(name = "password",nullable = false,columnDefinition = "VARCHAR(100)")
    private String password ;






   @ManyToOne
    private Role role;

    @Column(name = "create_time",nullable = false,updatable = false,columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private LocalDateTime createTime ;

    @Column(name = "update_time",nullable = false,updatable = false,columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private LocalDateTime updateTime ;

    public User() {
    }

    public User(Integer userId, String username, String password, Role role, LocalDateTime createTime, LocalDateTime updateTime) {
        UserId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public User(String username, String password, Role role, LocalDateTime createTime, LocalDateTime updateTime) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;

    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
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
