package com.example.WebApplication.repositories;

import com.example.WebApplication.entities.Ad;
import org.springframework.data.repository.CrudRepository;

public interface AdRepository extends CrudRepository<Ad, Long> {
    Ad findAdById(Long id);
}
