package com.app.cesaviden.nautica.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.cesaviden.nautica.entities.BoatEntity;
import com.app.cesaviden.nautica.services.implementation.BoatServiceImpl;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/boats")
@Validated
public class BoatController {

    @Autowired
    private BoatServiceImpl boatService;

    @GetMapping
    public ResponseEntity<List<BoatEntity>> getAllBoats() {
        return ResponseEntity.ok(boatService.getAllBoats());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoatEntity> getBoatById(@PathVariable Integer id) {
        return ResponseEntity.ok(boatService.getBoatById(id));
    }

    @PostMapping
    public ResponseEntity<BoatEntity> createBoat(@RequestParam @Valid BoatEntity boatEntity) {

        return ResponseEntity.ok(boatService.createBoat(boatEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoatEntity> updateBoat(@PathVariable  Integer id, @RequestParam @Valid BoatEntity boatEntity) {

        return ResponseEntity.ok(boatService.updateBoat(id, boatEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoat(@PathVariable Integer id) {

        boatService.deleteBoat(id);
        return ResponseEntity.ok().build();
    }

}
