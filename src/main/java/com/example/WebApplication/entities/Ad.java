package com.example.WebApplication.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.*;
import java.nio.file.Files;

@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public File photo;

    public String photo_name;
    public String price;
    public String phone;
    public String description;

    public String getPhoto_name() {
        return photo_name;
    }

    public void setPhoto_name(String photo_name) {
        this.photo_name = photo_name;
    }

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

    public String savePhoto(File photo) throws IOException {
//        File p = new File("src/main/resources/static/pic/noPhoto.jpg");
//        byte fileContent[] = Files.readAllBytes(p.toPath());
//        if(photo != null)
//        if(photo == null)
//            fileContent = Files.readAllBytes(photo.toPath());
//        FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/static/pic/photo.jpg");
//        fileOutputStream.write(fileContent);
        return photo.getAbsolutePath();
    }
}
