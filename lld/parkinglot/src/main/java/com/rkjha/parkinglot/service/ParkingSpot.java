package com.rkjha.parkinglot.service;

public class ParkingSpot {

    private String id;
    private String type;
    private boolean isFree;


    public ParkingSpot(String id, String type, boolean isFree) {
        this.id = id;
        this.type = type;
        this.isFree = isFree;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public boolean isFree() {
        return isFree;
    }
    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }


}
