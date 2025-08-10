package com.rkjha.parkinglot.service;

import java.util.Map;

public class ParkingLot {
    int id;
    String name;
    String address;
    ParkingRate rate;
    Map<String, Entrance> entrances;
    Map<String,Exit> exits;
    Map<String, ParkingSpot> parkingSpots;
    Map<String, ParkingTicket> parkingTickets ;
    Map<String, DisplayBoard> displayBoards;

    public ParkingLot(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public  ParkingTicket getParkingTicket(String ticketId) {
        return this.parkingTickets.get(ticketId);
    }

    public boolean isFull() {
        return parkingSpots.isEmpty();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ParkingRate getRate() {
        return rate;
    }

    public void setRate(ParkingRate rate) {
        this.rate = rate;
    }

    public Map<String, Entrance> getEntrances() {
        return entrances;
    }

    public void setEntrances(Map<String, Entrance> entrances) {
        this.entrances = entrances;
    }

    public Map<String, Exit> getExits() {
        return exits;
    }

    public void setExits(Map<String, Exit> exits) {
        this.exits = exits;
    }

    public Map<String, ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(Map<String, ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public Map<String, ParkingTicket> getParkingTickets() {
        return parkingTickets;
    }

    public void setParkingTickets(Map<String, ParkingTicket> parkingTickets) {
        this.parkingTickets = parkingTickets;
    }

    public Map<String, DisplayBoard> getDisplayBoards() {
        return displayBoards;
    }

    public void setDisplayBoards(Map<String, DisplayBoard> displayBoards) {
        this.displayBoards = displayBoards;
    }


    
}
