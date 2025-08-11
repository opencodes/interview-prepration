package com.rkjha.parkinglot.service;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    int id;
    String name;
    String address;
    ParkingRate rate;
    Map<String, Entrance> entrances = new HashMap<>();
    Map<String,Exit> exits = new HashMap<>();
    Map<String, ParkingSpot> parkingSpots = new HashMap<>();
    Map<String, ParkingTicket> parkingTickets = new HashMap<>();
    Map<String, DisplayBoard> displayBoards = new HashMap<>();

    private static ParkingLot instance;
    private ParkingLot() {
        // Private constructor to prevent instantiation
    }
    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
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

    public Entrance getEntrance(String entranceId) {
        return this.entrances.get(entranceId);
    }

    public void addEntrance(Entrance entrance) {
        this.entrances.put(String.valueOf(entrance.id), entrance);
    }

    public Map<String, Exit> getExits() {
        return exits;
    }

    public void addExit(Exit exit) {
        this.exits.put(String.valueOf(exit.id), exit);
    }

    public Map<String, ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpots.put(String.valueOf(parkingSpot.getId()), parkingSpot);
    }

    public Map<String, ParkingTicket> getParkingTickets() {
        return parkingTickets;
    }

    public void addParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTickets.put(parkingTicket.getId(), parkingTicket);
    }

    public Map<String, DisplayBoard> getDisplayBoards() {
        return displayBoards;
    }

    public void addDisplayBoard(  DisplayBoard displayBoard) {
        this.displayBoards.put( displayBoard.id, displayBoard);
    }
 
 
    
}
