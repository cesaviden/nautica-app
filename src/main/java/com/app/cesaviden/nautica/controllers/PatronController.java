package com.app.cesaviden.nautica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.app.cesaviden.nautica.entities.PatronEntity;
import com.app.cesaviden.nautica.services.implementation.PatronServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patrons")
@Validated
public class PatronController {

    @Autowired
    private PatronServiceImpl patronService;

    @GetMapping
    public ResponseEntity<List<PatronEntity>> getAllPatrons() {
        List<PatronEntity> patrons = patronService.getAllPatrons();
        return ResponseEntity.ok().body(patrons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatronEntity> getPatronById(@PathVariable Integer id) {
        PatronEntity patron = patronService.getPatronById(id);
        return ResponseEntity.ok().body(patron);
    }

    @PostMapping
    public ResponseEntity<PatronEntity> createPatron(@RequestBody @Valid PatronEntity patron) {
        return ResponseEntity.ok(patronService.createPatron(patron));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable Integer id) {
        patronService.deletePatron(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatronEntity> updatePatron(@PathVariable Integer id, @RequestBody @Valid PatronEntity patron) {
        PatronEntity updatedPatron = patronService.updatePatron(id, patron);
        return ResponseEntity.ok().body(updatedPatron);
    }
}