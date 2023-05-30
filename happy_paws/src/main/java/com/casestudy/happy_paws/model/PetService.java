package com.casestudy.happy_paws.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE category SET status = true WHERE id=?")
@Where(clause = "status = false")

public class PetService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;


    @Column(name = "image",columnDefinition = "TEXT")
    private String image;

    @Column(name = "createTime" , nullable = false,updatable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private LocalDateTime createTime;

    @Column(name = "updateTime", nullable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private LocalDateTime updateTime;


    private Boolean status = false;

    public PetService() {
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public PetService(Integer id, String name, String description, String image, LocalDateTime createTime, LocalDateTime updateTime, Boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    public PetService(String name, String description, String image, LocalDateTime createTime, LocalDateTime updateTime, Boolean status) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    public PetService(Integer id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public PetService(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
