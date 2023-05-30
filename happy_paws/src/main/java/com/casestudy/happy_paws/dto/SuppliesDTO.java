package com.casestudy.happy_paws.dto;

import com.casestudy.happy_paws.model.SuppliesType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDateTime;


public class SuppliesDTO implements Validator {
    private Long id;
    private String nameSupplies;
    private String description;
    private Long price;
    private String origin;
    private String image;

    private SuppliesType suppliesType;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;
    private boolean isDelete;

    public SuppliesDTO() {
    }

    public SuppliesDTO(Long id, String nameSupplies, String description, Long price, String origin, String image, SuppliesType suppliesType, LocalDateTime createDate, LocalDateTime updateDate, boolean isDelete) {
        this.id = id;
        this.nameSupplies = nameSupplies;
        this.description = description;
        this.price = price;
        this.origin = origin;
        this.image = image;
        this.suppliesType = suppliesType;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.isDelete = isDelete;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSupplies() {
        return nameSupplies;
    }

    public void setNameSupplies(String nameSupplies) {
        this.nameSupplies = nameSupplies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public SuppliesType getSuppliesType() {
        return suppliesType;
    }

    public void setSuppliesType(SuppliesType suppliesType) {
        this.suppliesType = suppliesType;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
