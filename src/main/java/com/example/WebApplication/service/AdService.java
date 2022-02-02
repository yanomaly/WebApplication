package com.example.WebApplication.service;

import com.dropbox.core.*;
import com.example.WebApplication.entities.Ad;
import com.example.WebApplication.entities.UserAdds;
import com.example.WebApplication.repositories.AdRepository;
import com.example.WebApplication.repositories.UserAddsRepository;
import com.example.WebApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
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

    public boolean saveAd(Ad ad, Long userID, MultipartFile photo) throws IOException {
        if(ad.getDescription() != null && ad.getPhone() != null && ad.getPrice() != null){
            String patternPrice = "([1-9][0-9]*)|([1-9][0-9]*\\.[1-9][0-9])";
            String patternPhone = "(\\+[0-9]{12})|8[0-9]{10}";
            if(Pattern.compile(patternPrice).matcher(ad.getPrice()).matches() && Pattern.compile(patternPhone).matcher(ad.getPhone()).matches()) {
                if(!photo.isEmpty()) {
//                    DbxRequestConfig config = new DbxRequestConfig("dropbox/1.0", Locale.getDefault().toString());
//                    DbxClient client = new DbxClient(config, "sl.BBR2nyWZgxftIeXXac9XKKMGRoYZPxlcBBnOtDFnKzT4_2mNyZDSeriHyAeTjw1-SR5dLo4YIpGE8zldBUFCFLHoBYB5SXXfyYuGB1BCyn0n6aGSVEqHywA3erUIO4IbJQywHgs");
//                    try(InputStream inputStream = photo.getInputStream()){
//                        client.uploadFile("/" + photo.getOriginalFilename(), DbxWriteMode.add(), photo.getSize(), inputStream);
//                    } catch (DbxException e) {
//                        e.printStackTrace();
//                    }
                    String folder = "src/main/resources/static/pic/";
                    String folder_html = "/pic/";
                    Path path = Paths.get(folder + photo.getOriginalFilename());
                    new File(path.toString()).createNewFile();
                    byte[] bytes = photo.getBytes();
                    Files.write(path, bytes);
                    ad.setPhoto_path(folder_html + photo.getOriginalFilename());
                }
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
                    Double xi = Double.parseDouble(x.getPrice());
                    Double yi = Double.parseDouble(y.getPrice());
                    return xi.compareTo(yi);
                }).toList();
            case(2):
                return adRepository.findAll().stream().sorted((x,y) ->{
                    Double xi = Double.parseDouble(x.getPrice());
                    Double yi = Double.parseDouble(y.getPrice());
                    return yi.compareTo(xi);
                }).toList();
            default:
                List<Ad> result = new LinkedList<>();
                adRepository.findAll().stream().forEach(x -> result.add(0, x));
                return result;
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
        if(adRepository.getById(ad.getId()).getPhoto_path().compareTo("/pic/noPhoto.jpg") != 0)
            new File("src/main/resources/static" + adRepository.getById(ad.getId()).getPhoto_path()).delete();
        userAddsRepository.delete(userAddsRepository.getByAdID(ad.getId()));
        adRepository.deleteById(ad.getId());
    }
}
