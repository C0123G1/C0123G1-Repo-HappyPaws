package com.casestudy.happy_paws.dto;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class PetServiceDTO implements Validator {

    private Long petServiceId;


    @NotBlank(message = "This field is required")
    @Size(max = 100, message = "")
    private String name;
    private String description;
    @NotBlank(message = "This field is required")
    private Double price;
    private String image;
    private boolean isDelete = false;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public PetServiceDTO() {
    }

    public PetServiceDTO(Long petServiceId, String name, String description, Double price, String image, boolean isDelete, LocalDateTime createTime, LocalDateTime updateTime) {
        this.petServiceId = petServiceId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PetServiceDTO(String name, String description, Double price, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public Long getPetServiceId() {
        return petServiceId;
    }

    public void setPetServiceId(Long petServiceId) {
        this.petServiceId = petServiceId;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
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
