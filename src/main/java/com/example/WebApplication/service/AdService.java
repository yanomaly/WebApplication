package com.example.WebApplication.service;

import com.example.WebApplication.entities.Ad;
import com.example.WebApplication.repositories.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdService  {

    @Autowired
    AdRepository adRepository;

    public boolean saveAd(Ad ad){
        if(adRepository.save(ad).equals(ad))
        return true;
        else return false;
    }
}
