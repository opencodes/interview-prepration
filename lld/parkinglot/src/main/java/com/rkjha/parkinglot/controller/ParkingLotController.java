package com.rkjha.parkinglot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkjha.parkinglot.service.DisplayBoard;
import com.rkjha.parkinglot.service.Entrance;
import com.rkjha.parkinglot.service.Exit;
import com.rkjha.parkinglot.service.ParkingLot;
import com.rkjha.parkinglot.service.ParkingRate;
import com.rkjha.parkinglot.service.ParkingSpot;
import com.rkjha.parkinglot.service.ParkingTicket;
import com.rkjha.parkinglot.service.*;

@RestController
@RequestMapping("/parking-lot")
public class ParkingLotController {
    private static final Logger logger = LoggerFactory.getLogger(ParkingLotController.class);

    @RequestMapping("/index")
    public ResponseEntity<?> index() {

        try {
            ParkingLot parkingLot = ParkingLot.getInstance();
            parkingLot.setId(1);
            parkingLot.setName("Central Parking Lot");
            parkingLot.setAddress("123 Main St, Springfield");
            parkingLot.setRate(new ParkingRate(100.0, 100.0, 2.0));
            parkingLot.addParkingSpot(new ParkingSpot("PS1", "Compact", true));
            parkingLot.addParkingSpot(new ParkingSpot("PS14", "Large", true));
            parkingLot.addEntrance(new Entrance("ENT1"));
            parkingLot.addExit(new Exit("EXT1"));
            parkingLot.addDisplayBoard(new DisplayBoard("DB1"));

            // add vehicle entry and exit for testing
            Car car1 = new Car("ABC123");
            parkingLot.addParkingTicket(parkingLot.getEntrance("ENT1").getTicket(car1, "TICKET1"));
            ParkingTicket parkingTicket = parkingLot.getParkingTicket("TICKET1");
            // parkingTicket.setExiDate(LocalDateTime.now().plusHours(6));

            parkingLot.getExit("EXT1").markExit(parkingTicket, parkingLot.getRate());

            return ResponseEntity.ok(parkingLot);
        } catch (Exception e) {
            logger.error("Error while creating ParkingLot object", e);

            // Return a helpful error response instead of stale/empty object
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while fetching parking lot data. Please try again later.");
        }
    }

    // Add this method to handle root URL
    @RequestMapping(value = "/", path = "/", produces = "text/plain")
    public String home() {
        return "Parking Lot API is running!";
    }

}
