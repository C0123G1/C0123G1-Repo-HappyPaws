package com.casestudy.happy_paws.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class PetServiceDTO implements Validator {

    private Integer id;

    @Size(max = 200, message = "Maximum 200 characters")
    @NotBlank(message = "Must be filled")
    private String name;


    @Size(max = 1000, message = "Maximum 1000 characters")
    private String description;
    private MultipartFile image;



    private LocalDateTime createTime;

    private LocalDateTime updateTime;


    private Boolean status = false;

    public PetServiceDTO() {

    }

//    public PetServiceDTO(PetServiceDTOBuilder petServiceDTOBuilder) {
//        this.name = petServiceDTOBuilder.name;
//        this.description = petServiceDTOBuilder.description;
//        this.image = petServiceDTOBuilder.image;}
//        public static class PetServiceDTOBuilder {
//            private final String name;
//            private String description;
//            private MultipartFile image;
//
//            public PetServiceDTOBuilder(String name) {
//                this.name = name;
//            }
//
//            public PetServiceDTOBuilder description(String description) {
//                this.description = description;
//                return this;
//            }
//
//            public PetServiceDTOBuilder image(MultipartFile image) {
//                this.image = image;
//                return this;
//            }
//
//            public PetServiceDTO build() {
//                return new PetServiceDTO(this);
//            }
//        }

    @Transient
    public String getPhotosImagePath() {
        if (image == null || id == null) return null;

        return "/service-photos/" + id + "/" + image;
    }

    public PetServiceDTO(String name, String description) {
        this.name = name;
        this.description = description;
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

    public PetServiceDTO(Integer id, String name, String description, MultipartFile image, LocalDateTime createTime, LocalDateTime updateTime, Boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    public PetServiceDTO(String name, String description, MultipartFile image, LocalDateTime createTime, LocalDateTime updateTime, Boolean status) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    public PetServiceDTO(Integer id, String name, String description, MultipartFile image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public PetServiceDTO(String name, String description, MultipartFile image) {
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
