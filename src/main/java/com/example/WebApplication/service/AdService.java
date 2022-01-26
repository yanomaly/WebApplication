package com.example.WebApplication.service;

import com.example.WebApplication.entities.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdService  {

    @Autowired
    AdService adService;

    public boolean saveAd(Ad ad){
      return false;
    }
}
