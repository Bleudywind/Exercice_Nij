package com.example.demo.jsonplaceholder.models;

import com.example.demo.models.base.EntityBase;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@Entity
public class Geo extends EntityBase {

    private String lat;
    private String lng;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
