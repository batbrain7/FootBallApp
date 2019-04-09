package com.example.mohitkumar.footballapp.core.main;

public class CardItem {

    private String leagueName;
    private String country;
    private String imageURL;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public CardItem(String leagueName, String country, String imageURL) {
        this.leagueName = leagueName;
        this.country = country;
        this.imageURL = imageURL;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public String getCountry() {
        return country;
    }
}
