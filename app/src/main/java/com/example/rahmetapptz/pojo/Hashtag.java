package com.example.rahmetapptz.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hashtag {
    @SerializedName("hashtag_id")
    @Expose
    private Integer hashtagId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("is_hidden")
    @Expose
    private Boolean isHidden;
    @SerializedName("inherited")
    @Expose
    private Boolean inherited;

    public Integer getHashtagId() {
        return hashtagId;
    }

    public void setHashtagId(Integer hashtagId) {
        this.hashtagId = hashtagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    public Boolean getInherited() {
        return inherited;
    }

    public void setInherited(Boolean inherited) {
        this.inherited = inherited;
    }
}
