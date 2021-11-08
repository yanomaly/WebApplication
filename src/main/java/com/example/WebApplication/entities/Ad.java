package com.example.WebApplication.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ad {
    @Id
    @GeneratedValue()
    private long id;

    
}
