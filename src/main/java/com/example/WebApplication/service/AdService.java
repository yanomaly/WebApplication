package com.example.WebApplication.service;

import com.example.WebApplication.entities.Ad;
import com.example.WebApplication.entities.UserAdds;
import com.example.WebApplication.repositories.AdRepository;
import com.example.WebApplication.repositories.UserAddsRepository;
import com.example.WebApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class AdService  {

    @Autowired
    AdRepository adRepository;
    @Autowired
    UserAddsRepository userAddsRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserAddsService userAddsService;

    public boolean saveAd(Ad ad, Long userID){
        if(ad.getDescription() != null && ad.getPhone() != null && ad.getPhoto() != null && ad.getPrice() != null){
            String patternPrice = "[1-9][0-9]*";
            String patternPhone = "(\\+[0-9]{12})|8[0-9]{10}";
            if(Pattern.compile(patternPrice).matcher(ad.getPrice()).matches() && Pattern.compile(patternPhone).matcher(ad.getPhone()).matches()) {
                adRepository.save(ad);
                userAddsRepository.save(new UserAdds(userID, ad.getId()));
                return true;
            }
            else return false;
        }
        else return false;
    }

    public List<Ad> getAllAddsByID(){
        List<Ad> adds = new ArrayList<>();
        Long UserID = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        List<Long> addsID = userAddsService.findAddsID(UserID);
        addsID.forEach(x -> adds.add(adRepository.getById(x)));
        return adds;
    }

    public List<Ad> getAll(Integer order){
        switch(order){
            case(1):
                return adRepository.findAll().stream().sorted((x,y) ->{
                    Integer xi = Integer.parseInt(x.getPrice());
                    Integer yi = Integer.parseInt(y.getPrice());
                    return xi.compareTo(yi);
                }).toList();
            case(2):
                return adRepository.findAll().stream().sorted((x,y) ->{
                    Integer xi = Integer.parseInt(x.getPrice());
                    Integer yi = Integer.parseInt(y.getPrice());
                    return yi.compareTo(xi);
                }).toList();
            default:
                return adRepository.findAll();
        }
    }

    public List<Ad> getThreeLast() {
        if(adRepository.findAll().size() == 0)
            return adRepository.findAll();
        else
        if(adRepository.findAll().size() < 3 && adRepository.findAll().size() > 0)
        return adRepository.findAll().subList(0, adRepository.findAll().size());
        else
            return adRepository.findAll().subList(adRepository.findAll().size() - 3, adRepository.findAll().size());
    }

    public void deleteAdd(Ad ad){
        userAddsRepository.delete(userAddsRepository.getByAdID(ad.getId()));
        adRepository.deleteById(ad.getId());
    }
}
