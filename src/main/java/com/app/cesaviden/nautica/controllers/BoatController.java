package com.app.cesaviden.nautica.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.cesaviden.nautica.controllers.dto.BoatCreationRequestDTO;
import com.app.cesaviden.nautica.entities.BoatEntity;
import com.app.cesaviden.nautica.services.implementation.BoatServiceImpl;
import com.app.cesaviden.nautica.services.implementation.MemberServiceImpl;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/boats")
@Validated
public class BoatController {

    @Autowired
    private BoatServiceImpl boatService;

    @Autowired
    private MemberServiceImpl memberService;

    @GetMapping
    public ResponseEntity<?> getAllBoats() {
        try {
            List<BoatEntity> boats = boatService.getAllBoats();
            return ResponseEntity.status(HttpStatus.OK).body(boats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching boats: " + e.getMessage());
        }
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<?> getBoatsByOwnerId(@PathVariable Integer ownerId) {
        try {
            List<BoatEntity> boats = boatService.getBoatsByOwnerId(ownerId);
            return ResponseEntity.status(HttpStatus.OK).body(boats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching boats by owner ID: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBoatById(@PathVariable Integer id) {
        try {
            BoatEntity boat = boatService.getBoatById(id);
            return ResponseEntity.status(HttpStatus.OK).body(boat);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching boat by ID: " + e.getMessage());
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getBoatByName(@PathVariable String name) {
        try {
            List<BoatEntity> boat = boatService.getBoatByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(boat);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching boat by name: " + e.getMessage());
        }
    }

    @GetMapping("mooringnumber/{mooringNumber}")
    public ResponseEntity<?> getBoatByMooringNumber(@PathVariable Integer mooringNumber) {
        try {
            List<BoatEntity> boat = boatService.getBoatByMooringNumber(mooringNumber);
            return ResponseEntity.status(HttpStatus.OK).body(boat);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching boat by mooring number: " + e.getMessage());
        }
    }

    @GetMapping("/fee/{fee}")
    public ResponseEntity<?> getBoatWithFreGreaterThan(@PathVariable Integer fee) {
        try {
            List<BoatEntity> boats = boatService.getBoatWithFeeGreaterThan(fee);
            return ResponseEntity.status(HttpStatus.OK).body(boats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching boats with fee greater than: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createBoat(@RequestBody @Valid BoatCreationRequestDTO boatRequest) {
        try {
            BoatEntity boatEntity = new BoatEntity();
            boatEntity.setRegistrationNumber(boatRequest.registrationNumber());
            boatEntity.setName(boatRequest.name());
            boatEntity.setMooringNumber(boatRequest.mooringNumber());
            boatEntity.setFee(boatRequest.fee());
            boatEntity.setOwner(memberService.getMemberById(boatRequest.ownerId()));

            // Aquí puedes establecer el propietario si es necesario antes de crear el barco
            // boatEntity.setOwner(ownerEntity);

            BoatEntity createdBoat = boatService.createBoat(boatRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBoat);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating boat: " + e.getMessage());
        }
    }

    @PostMapping("/{id}/owner/{ownerId}")
    public ResponseEntity<?> addOwnerToBoat(@PathVariable Integer id, @PathVariable Integer ownerId) {
        try {
            boatService.addOwnerToBoat(id, ownerId);
            return ResponseEntity.status(HttpStatus.OK).body("Owner added to boat successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error adding owner to boat: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBoat(@PathVariable Integer id, @RequestBody @Valid BoatEntity boatEntity) {
        try {
            BoatEntity updatedBoat = boatService.updateBoat(id, boatEntity);
            return ResponseEntity.ok("Boat updated successfully with ID: " + updatedBoat.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating boat: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBoat(@PathVariable Integer id) {
        try {
            boatService.deleteBoat(id);
            return ResponseEntity.status(HttpStatus.OK).body("Boat deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting boat: " + e.getMessage());
        }
    }
}
