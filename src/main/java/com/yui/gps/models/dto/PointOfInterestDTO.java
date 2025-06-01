package com.yui.gps.models.dto;

import com.yui.gps.models.entities.PointOfInterest;

public class PointOfInterestDTO {

    private Long id;
    private String name;
    private Integer x;
    private Integer y;

    public  PointOfInterestDTO(){}

    public PointOfInterestDTO(Long id, String name, Integer x, Integer y) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public PointOfInterestDTO(PointOfInterest pointOfInterest){
        this.id = pointOfInterest.getId();
        this.name = pointOfInterest.getName();
        this.x = pointOfInterest.getX();
        this.y = pointOfInterest.getY();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
