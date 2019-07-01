package com.example.rahmetapptz.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("coordLat")
    @Expose
    private Double coordLat;
    @SerializedName("coordLng")
    @Expose
    private Double coordLng;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getCoordLat() {
        return coordLat;
    }

    public void setCoordLat(Double coordLat) {
        this.coordLat = coordLat;
    }

    public Double getCoordLng() {
        return coordLng;
    }

    public void setCoordLng(Double coordLng) {
        this.coordLng = coordLng;
    }
}
