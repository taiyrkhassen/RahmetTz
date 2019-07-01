package com.example.rahmetapptz.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SocialNetworks {
    @SerializedName("ins")
    @Expose
    private String instagram;

    @SerializedName("fb")
    @Expose
    private String facebook;
    @SerializedName("vk")
    @Expose
    private String vk;

    @SerializedName("youtube")
    @Expose
    private String youtube;

    @SerializedName("twitter")
    @Expose
    private String twitter;


    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getVk() {
        return vk;
    }

    public void setVk(String vk) {
        this.vk = vk;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
}
