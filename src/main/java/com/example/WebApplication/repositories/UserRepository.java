package com.example.WebApplication.repositories;

import com.example.WebApplication.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
