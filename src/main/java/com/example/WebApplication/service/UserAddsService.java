package com.example.WebApplication.service;

import com.example.WebApplication.entities.UserAdds;
import com.example.WebApplication.repositories.UserAddsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAddsService {
    @Autowired
    UserAddsRepository userAddsRepository;

    public List<Long> findAddsID(Long userID){
        List<UserAdds> userAdds = userAddsRepository.findAllByUserID(userID);
        List<Long> IDs = new ArrayList<>();
        userAdds.forEach(x -> IDs.add(x.getAdID()));
        return IDs;
    }
}
