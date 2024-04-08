package com.app.cesaviden.nautica.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cesaviden.nautica.controllers.dto.BoatCreationRequestDTO;
import com.app.cesaviden.nautica.entities.BoatEntity;
import com.app.cesaviden.nautica.entities.MemberEntity;
import com.app.cesaviden.nautica.repositories.BoatRepository;
import com.app.cesaviden.nautica.repositories.MemberRepository;
import com.app.cesaviden.nautica.services.interfaces.BoatService;

@Service
public class BoatServiceImpl implements BoatService {

    @Autowired
    private BoatRepository boatRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<BoatEntity> getAllBoats() {
        return boatRepository.findAll();
    }

    @Override
    public BoatEntity getBoatById(Integer id) {
        return boatRepository.findById(id).orElse(null);
    }

    @Override
    public BoatEntity createBoat(BoatCreationRequestDTO boatRequest) {
        return boatRepository.save(BoatEntity.builder().name(boatRequest.name()).registrationNumber(boatRequest.registrationNumber()).mooringNumber(boatRequest.mooringNumber()).fee(boatRequest.fee()).owner(memberRepository.findById(boatRequest.ownerId()).orElse(null)).build());
    }

    @Override
    public BoatEntity addOwnerToBoat(Integer boatId, Integer ownerId) {

        BoatEntity existingBoat = boatRepository.findById(boatId).orElse(null);
        MemberEntity owner = memberRepository.findById(ownerId).orElse(null);

        if (existingBoat != null) {
            existingBoat.setOwner(owner);
            return boatRepository.save(existingBoat);
    } 
        return null;
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

    @Override
    public List<BoatEntity> getBoatsByOwnerId(Integer ownerId) {

        return boatRepository.findAllByOwnerId(ownerId);
    }

    @Override
    public List<BoatEntity> getBoatByName(String name) {
        return boatRepository.findByName(name);
    }

    @Override
    public List<BoatEntity> getBoatByMooringNumber(Integer mooringNumber) {
        return boatRepository.findByMooringNumber(mooringNumber);
    }

    @Override
    public List<BoatEntity> getBoatWithFeeGreaterThan(Integer fee) {
        return boatRepository.findByFeeGreaterThan(fee);
    }
}
