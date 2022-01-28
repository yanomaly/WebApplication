package com.example.WebApplication.repositories;

import com.example.WebApplication.entities.UserAdds;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAddsRepository extends JpaRepository<UserAdds, Long> {
    List<UserAdds> findAllByUserID(Long userID);
}
