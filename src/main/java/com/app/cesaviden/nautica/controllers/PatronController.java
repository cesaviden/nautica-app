package com.app.cesaviden.nautica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.app.cesaviden.nautica.entities.PatronEntity;
import com.app.cesaviden.nautica.services.implementation.PatronServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/patrons")
@Validated
public class PatronController {


    @Autowired
    private PatronServiceImpl patronService;


    @GetMapping
    public List<PatronEntity> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    @GetMapping("/{id}")
    public PatronEntity getPatronById(@PathVariable Integer id) {
        return patronService.getPatronById(id);
    }

    @PostMapping
    public PatronEntity createPatron(@RequestBody @Valid PatronEntity patron) {
        return patronService.createPatron(patron);
    }

    @DeleteMapping("/{id}")
    public void deletePatron(@PathVariable Integer id) {
        patronService.deletePatron(id);
    }

    @PutMapping("/{id}")
    public PatronEntity updatePatron(@PathVariable Integer id, @RequestBody @Valid PatronEntity patron) {
        return patronService.updatePatron(id, patron);
    }
    

    


}
