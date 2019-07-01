package com.example.rahmetapptz.pojo;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("town_id")
    @Expose
    private Integer townId;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("phones")
    @Expose
    private List<String> phones = null;
    @SerializedName("regime")
    @Expose
    private List<Regime> regime = null;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("images")
    @Expose
    private List<String> images = null;
    @SerializedName("rule")
    @Expose
    private Rule rule;
    @SerializedName("rating")
    @Expose
    private Rating rating;
    @SerializedName("partner")
    @Expose
    private Partner partner;
    @SerializedName("hashtags")
    @Expose
    private List<Hashtag> hashtags = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTownId() {
        return townId;
    }

    public void setTownId(Integer townId) {
        this.townId = townId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public List<Regime> getRegime() {
        return regime;
    }

    public void setRegime(List<Regime> regime) {
        this.regime = regime;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
}
