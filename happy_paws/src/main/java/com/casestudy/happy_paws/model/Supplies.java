package com.casestudy.happy_paws.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Supplies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nameSupplies;
    @Column(columnDefinition = "text")
    private String description;
    @NotNull
    private Long price;
    @NotNull
    private String origin;
    @Column(columnDefinition = "text")
    private String image;
    @ManyToOne
    @JoinColumn
    private SuppliesType suppliesType;
    @Column(nullable = false, updatable = false,columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private LocalDateTime createDate;
    @Column(nullable = false,columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private LocalDateTime updateDate;
    private boolean isDelete;

    public Supplies() {
    }

    public Supplies(Long id, String nameSupplies, String description, Long price, String origin,String image, SuppliesType suppliesType, LocalDateTime createDate, LocalDateTime updateDate, boolean isDelete) {
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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
