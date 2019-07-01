package com.example.rahmetapptz.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Partner {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("logotype_url")
    @Expose
    private String logotypeUrl;
    @SerializedName("website_url")
    @Expose
    private String websiteUrl;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("social_networks")
    @Expose
    private SocialNetworks socialNetworks;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("filials")
    @Expose
    private List<Object> filials = null;

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

    public String getLogotypeUrl() {
        return logotypeUrl;
    }

    public void setLogotypeUrl(String logotypeUrl) {
        this.logotypeUrl = logotypeUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SocialNetworks getSocialNetworks() {
        return socialNetworks;
    }

    public void setSocialNetworks(SocialNetworks socialNetworks) {
        this.socialNetworks = socialNetworks;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Object> getFilials() {
        return filials;
    }

    public void setFilials(List<Object> filials) {
        this.filials = filials;
    }
}
