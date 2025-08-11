package com.rkjha.parkinglot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkjha.parkinglot.service.*;

@RestController
@RequestMapping("/parking-lot")
public class ParkingLotController {
    private static final Logger logger = LoggerFactory.getLogger(ParkingLotController.class);

    @RequestMapping("/index")
    public ResponseEntity<?> index() {

        try {
            ParkingLot lot = ParkingLot.getInstance();
            lot.addSpot(new Handicapped(1));
            lot.addSpot(new Compact(2));
            lot.addSpot(new Large(3));
            lot.addSpot(new MotorcycleSpot(4));

            DisplayBoard board = new DisplayBoard(1);
            lot.addDisplayBoard(board);

            Entrance entrance = new Entrance("1");
            Exit exit = new Exit("");

            Vehicle car = new Car("KA-01-HH-1234");
            System.out.println("-> Car " + car.getLicenseNo() + " arrives at entrance");
            ParkingTicket ticket1 = entrance.getTicket(car);

            System.out.println("-> Updating display board after parking:");
            board.update(lot.getAllSpots());
            board.showFreeSlot();

            // ----------------- SCENARIO 2: CUSTOMER EXITS AND PAYS -----------------
            System.out.println("\n→→→ SCENARIO 2: Customer exits and pays\n");

            System.out.println("-> Car " + car.getLicenseNo() + " proceeds to exit panel");
            Thread.sleep(1500); // Simulate parking duration (1.5 sec)
            exit.validateTicket(ticket1);

            System.out.println("-> Updating display board after exit:");
            board.update(lot.getAllSpots());
            board.showFreeSlot();

            // --------- SCENARIO 3: FILLING LOT AND REJECTING ENTRY IF FULL ---------
            System.out.println("\n→→→ SCENARIO 3: Multiple customers attempt to enter; lot may become full\n");

            // Vehicles arriving
            Vehicle van = new Van("KA-01-HH-9999");
            Vehicle motorcycle = new MotorCycle("KA-02-XX-3333");
            Vehicle truck = new Truck("KA-04-AA-9998");
            Vehicle car2 = new Car("DL-09-YY-1234");

            System.out.println("-> Van " + van.getLicenseNo() + " arrives at entrance");
            ParkingTicket ticket2 = entrance.getTicket(van);

            System.out.println("-> Motorcycle " + motorcycle.getLicenseNo() + " arrives at entrance");
            ParkingTicket ticket3 = entrance.getTicket(motorcycle);

            System.out.println("-> Truck " + truck.getLicenseNo() + " arrives at entrance");
            ParkingTicket ticket4 = entrance.getTicket(truck);

            System.out.println("-> Car " + car2.getLicenseNo() + " arrives at entrance");
            ParkingTicket ticket5 = entrance.getTicket(car2);

            System.out.println("-> Updating display board after several parkings:");
            board.update(lot.getAllSpots());
            board.showFreeSlot();

            // Try to park another car (lot may now be full)
            Vehicle car3 = new Car("UP-01-CC-1001");
            System.out
                    .println("-> Car " + car3.getLicenseNo() + " attempts to park (should be denied if lot is full):");
            ParkingTicket ticket6 = entrance.getTicket(car3);

            board.update(lot.getAllSpots());
            board.showFreeSlot();

            return ResponseEntity.ok(lot);
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
