package com.app.cesaviden.nautica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.app.cesaviden.nautica.entities.TripEntity;
import com.app.cesaviden.nautica.services.implementation.TripServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/trips")
@Validated
public class TripController {

    @Autowired
    private TripServiceImpl tripService;

    @GetMapping
    public ResponseEntity<List<TripEntity>> getAllTrips() {
        return ResponseEntity.ok(tripService.getAllTrips());
    }

    @GetMapping("/boat/{boatId}")
    public ResponseEntity<List<TripEntity>> getAllTripsByBoatId(@PathVariable Integer boatId) {
        return ResponseEntity.ok(tripService.getAllTripsByBoatId(boatId));
    }

    @GetMapping("/patron/{patronId}")
    public ResponseEntity<List<TripEntity>> getAllTripsByPatronId(@PathVariable Integer patronId) {
        return ResponseEntity.ok(tripService.getAllTripsByPatronId(patronId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripEntity> getTripById(@PathVariable Integer id) {
        return ResponseEntity.ok(tripService.getTripById(id));
    }

    @PostMapping
    public ResponseEntity<TripEntity> createTrip(@RequestBody @Valid TripEntity tripEntity) {
        return ResponseEntity.ok(tripService.createTrip(tripEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TripEntity> updateTrip(@PathVariable Integer id, @RequestBody @Valid TripEntity tripEntity) {
        return ResponseEntity.ok(tripService.updateTrip(id, tripEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Integer id) {
        tripService.deleteTrip(id);
        return ResponseEntity.ok().build();
    }

}
