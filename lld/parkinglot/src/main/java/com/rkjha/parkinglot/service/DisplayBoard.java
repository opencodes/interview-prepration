package com.rkjha.parkinglot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayBoard {
    int id;
    Map<String, List<ParkingSpot>> parkingSpot;

    public void addParkingSpot(List<ParkingSpot> parkingSpots, String vehicleType ) {
        this.parkingSpot.put(vehicleType, parkingSpots);
    }

    public Map<String, List<ParkingSpot>> showFreeSpot() {
        //iterate through parkingSpot and return the list of free parking spots, unassigned vehicles
        Map<String, List<ParkingSpot>> freeSpots = new HashMap<>();
        for (Map.Entry<String, List<ParkingSpot>> entry : parkingSpot.entrySet()) {
            String vehicleType = entry.getKey();
            List<ParkingSpot> spots = entry.getValue();

            List<ParkingSpot> freeSpotsList = new ArrayList<>();
            for (ParkingSpot spot : spots) {
                if (spot.isFree()) {
                    freeSpotsList.add(spot);
                }
            }
            if (!freeSpotsList.isEmpty()) {
                freeSpots.put(vehicleType, freeSpotsList);
            }
        }
        return freeSpots;
    }
}
