package com.example.WebApplication.entities;

import javax.persistence.*;

@Entity
public class UserAdds {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userID;
    private Long adID;

    public UserAdds(Long userID, Long adID) {
        this.userID = userID;
        this.adID = adID;
    }

    public UserAdds() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getAdID() {
        return adID;
    }

    public void setAdID(Long adID) {
        this.adID = adID;
    }
}
