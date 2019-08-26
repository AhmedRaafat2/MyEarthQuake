package com.example.myearthquake;

public class EarthQuake {
    private double earthQuake_mag;
    private String earthQuake_nearbyPlace;
    private String earthQuake_Place;
    private String earthQuake_date;
    private String earthQuake_time;
    private String earthQuake_url;

    public EarthQuake(double earthQuake_mag, String earthQuake_nearbyPlace, String earthQuake_Place, String earthQuake_date, String earthQuake_time, String earthQuake_url) {
        this.earthQuake_mag = earthQuake_mag;
        this.earthQuake_nearbyPlace = earthQuake_nearbyPlace;
        this.earthQuake_Place = earthQuake_Place;
        this.earthQuake_date = earthQuake_date;
        this.earthQuake_time = earthQuake_time;
        this.earthQuake_url = earthQuake_url;
    }

    public double getEarthQuake_mag() {
        return earthQuake_mag;
    }

    public void setEarthQuake_mag(double earthQuake_mag) {
        this.earthQuake_mag = earthQuake_mag;
    }

    public String getEarthQuake_nearbyPlace() {
        return earthQuake_nearbyPlace;
    }

    public void setEarthQuake_nearbyPlace(String earthQuake_nearbyPlace) {
        this.earthQuake_nearbyPlace = earthQuake_nearbyPlace;
    }

    public String getEarthQuake_Place() {
        return earthQuake_Place;
    }

    public void setEarthQuake_Place(String earthQuake_Place) {
        this.earthQuake_Place = earthQuake_Place;
    }

    public String getEarthQuake_date() {
        return earthQuake_date;
    }

    public void setEarthQuake_date(String earthQuake_date) {
        this.earthQuake_date = earthQuake_date;
    }

    public String getEarthQuake_time() {
        return earthQuake_time;
    }

    public void setEarthQuake_time(String earthQuake_time) {
        this.earthQuake_time = earthQuake_time;
    }

    public String getEarthQuake_url() {
        return earthQuake_url;
    }

    public void setEarthQuake_url(String earthQuake_url) {
        this.earthQuake_url = earthQuake_url;
    }
}