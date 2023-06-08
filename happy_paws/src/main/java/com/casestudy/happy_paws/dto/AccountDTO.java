package com.casestudy.happy_paws.dto;

import com.casestudy.happy_paws.model.Role;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class AccountDTO {

    private Integer accountId;


    @Size(max = 100 , message = "username cannot longer than 100 character !!!")
    private String username;
    @Size(max = 500 , message = "username cannot longer than 100 character !!!")
    private String password;


    @OneToOne(mappedBy = "role")
    private Role role;

    @Column(name = "create_time",nullable = false,updatable = false,columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private LocalDateTime createTime ;

    @Column(name = "update_time",nullable = false,updatable = false,columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private LocalDateTime updateTime ;

    @NotNull
    private int code ;
    @NotNull
    private boolean enable ;

    public AccountDTO(Integer accountId, String username, String password, Role role, LocalDateTime createTime, LocalDateTime updateTime, int code, boolean enable) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.code =code;
        this.enable=enable;

    }

    public AccountDTO(String username, String password, Role role, LocalDateTime createTime, LocalDateTime updateTime,int code,boolean enable) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.code=code;
        this.enable = enable;
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


    public void setRole(Role role) {
        this.role = role;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
