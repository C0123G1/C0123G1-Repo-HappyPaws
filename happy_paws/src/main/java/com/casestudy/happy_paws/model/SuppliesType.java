package com.casestudy.happy_paws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class SuppliesType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nameTypeSupplies;
    private boolean isDelete;

    public SuppliesType() {
    }

    public SuppliesType(Long id, String nameTypeSupplies,boolean isDelete) {
        this.id = id;
        this.nameTypeSupplies = nameTypeSupplies;
        this.isDelete = isDelete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTypeSupplies() {
        return nameTypeSupplies;
    }

    public void setNameTypeSupplies(String nameTypeSupplies) {
        this.nameTypeSupplies = nameTypeSupplies;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
