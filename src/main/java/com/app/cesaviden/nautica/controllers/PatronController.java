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
    public ResponseEntity<?> getAllPatrons() {
        try {
            List<PatronEntity> patrons = patronService.getAllPatrons();
            return ResponseEntity.ok(patrons);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatronById(@PathVariable Integer id) {
        try {
            PatronEntity patron = patronService.getPatronById(id);
            return ResponseEntity.ok(patron);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<?> createPatron(@RequestBody @Valid PatronEntity patron) {
        try {
            PatronEntity createdPatron = patronService.createPatron(patron);
            return ResponseEntity.ok(createdPatron);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating patron: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatron(@PathVariable Integer id) {
        try {
            patronService.deletePatron(id);
            return ResponseEntity.ok("Patron deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting patron: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatron(@PathVariable Integer id, @RequestBody @Valid PatronEntity patron) {
        try {
            PatronEntity updatedPatron = patronService.updatePatron(id, patron);
            return ResponseEntity.ok(updatedPatron);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating patron: " + e.getMessage());
        }
    }
}
