package com.app.cesaviden.nautica.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cesaviden.nautica.entities.BoatEntity;
import com.app.cesaviden.nautica.repositories.BoatRepository;
import com.app.cesaviden.nautica.services.interfaces.BoatService;

@Service
public class BoatServiceImpl implements BoatService {

    @Autowired
    private BoatRepository boatRepository;

    @Override
    public List<BoatEntity> getAllBoats() {
        return boatRepository.findAll();
    }

    @Override
    public BoatEntity getBoatById(Integer id) {
        return boatRepository.findById(id).orElse(null);
    }

    @Override
    public BoatEntity createBoat(BoatEntity boatEntity) {
        return boatRepository.save(boatEntity);
    }

    @Override
    public BoatEntity updateBoat(Integer id, BoatEntity boatEntity) {

        BoatEntity existingBoat = boatRepository.findById(id).orElse(null);

        if (existingBoat != null) {
            existingBoat.setRegistrationNumber(boatEntity.getRegistrationNumber());
            existingBoat.setName(boatEntity.getName());
            existingBoat.setMooringNumber(boatEntity.getMooringNumber());
            existingBoat.setFee(boatEntity.getFee());
            existingBoat.setOwner(boatEntity.getOwner());
            return boatRepository.save(existingBoat);
        }

        return null;
    }

    @Override
    public void deleteBoat(Integer id) {
        boatRepository.deleteById(id);
    }
}