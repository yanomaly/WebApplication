package com.example.WebApplication.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.File;

@Entity
public class Ad {
    @Id
    @GeneratedValue()
    private long id;

    public File photo;
    public String price;
    public String phone;
    public String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }
}
