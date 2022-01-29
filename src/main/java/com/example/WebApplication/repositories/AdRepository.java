package com.example.WebApplication.repositories;

import com.example.WebApplication.entities.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {
    void deleteById(Long Id);
}
