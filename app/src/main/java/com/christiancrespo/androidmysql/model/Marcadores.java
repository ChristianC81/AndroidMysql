package com.christiancrespo.androidmysql.model;

public class Marcadores {
    private double latitude;
    private double longitude;
    private String city;
    private String description;

    public Marcadores() {
    }

    public Marcadores(double latitude, double longitude, String city, String description) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

