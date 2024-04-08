package com.app.cesaviden.nautica.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.app.cesaviden.nautica.controllers.dto.TripCreationRequestDTO;
import com.app.cesaviden.nautica.entities.TripEntity;
import com.app.cesaviden.nautica.services.implementation.BoatServiceImpl;
import com.app.cesaviden.nautica.services.implementation.PatronServiceImpl;
import com.app.cesaviden.nautica.services.implementation.TripServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/trips")
@Validated
public class TripController {

    @Autowired
    private TripServiceImpl tripService;

    @Autowired
    private PatronServiceImpl patronService;

    @Autowired
    private BoatServiceImpl boatService;

    @GetMapping
    public ResponseEntity<?> getAllTrips() {
        try {
            List<TripEntity> trips = tripService.getAllTrips();
            return ResponseEntity.ok(trips);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error getting trips: " + e.getMessage());
        }
    }

    @GetMapping("/boat/{boatId}")
    public ResponseEntity<?> getAllTripsByBoatId(@PathVariable Integer boatId) {
        try {
            List<TripEntity> trips = tripService.getAllTripsByBoatId(boatId);
            return ResponseEntity.status(HttpStatus.OK).body(trips);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/patron/{patronId}")
    public ResponseEntity<?> getAllTripsByPatronId(@PathVariable Integer patronId) {
        try {
            List<TripEntity> trips = tripService.getAllTripsByPatronId(patronId);
            return ResponseEntity.status(HttpStatus.OK).body(trips);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTripById(@PathVariable Integer id) {
        try {
            TripEntity trip = tripService.getTripById(id);
            return ResponseEntity.status(HttpStatus.OK).body(trip);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<?> createTrip(@RequestBody @Valid TripCreationRequestDTO tripRequest) {
        try {

            TripEntity tripEntity = new TripEntity();
            tripEntity.setBoat(boatService.getBoatById(tripRequest.boatId()));
            tripEntity.setPatron(patronService.getPatronById(tripRequest.patronId()));
            tripEntity.setDestination(tripRequest.destination());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            tripEntity.setDepartureDateTime(LocalDateTime.parse(tripRequest.departureDateTime(), formatter));
            tripService.createTrip(tripRequest);

            return ResponseEntity.status(HttpStatus.CREATED).body(tripEntity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating trip: " + e.getMessage());
        }
    }

    @PostMapping("/{tripId}/patron/{patronId}/boat/{boatId}")
    public ResponseEntity<?> addPatronAndBoatToTrip(@PathVariable Integer tripId, @PathVariable Integer patronId,
            @PathVariable Integer boatId) {
        try {
            tripService.addPatronAndBoatToTrip(tripId, patronId, boatId);
            return ResponseEntity.ok("Added patron and boat to trip successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error adding patron and boat to trip: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTrip(@PathVariable Integer id, @RequestBody @Valid TripEntity tripEntity) {
        try {
            TripEntity updatedTrip = tripService.updateTrip(id, tripEntity);
            return ResponseEntity.ok(updatedTrip);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating trip: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrip(@PathVariable Integer id) {
        try {
            tripService.deleteTrip(id);
            return ResponseEntity.ok("Trip deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting trip: " + e.getMessage());
        }
    }
}
