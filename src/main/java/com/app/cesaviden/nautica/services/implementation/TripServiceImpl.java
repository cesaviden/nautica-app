package com.app.cesaviden.nautica.services.implementation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cesaviden.nautica.controllers.dto.TripCreationRequestDTO;
import com.app.cesaviden.nautica.entities.BoatEntity;
import com.app.cesaviden.nautica.entities.TripEntity;
import com.app.cesaviden.nautica.repositories.BoatRepository;
import com.app.cesaviden.nautica.repositories.PatronRepository;
import com.app.cesaviden.nautica.repositories.TripRepository;
import com.app.cesaviden.nautica.services.interfaces.TripService;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private BoatRepository boatRepository;

    @Autowired
    private PatronRepository memberRepository;

    @Override
    public TripEntity createTrip(TripCreationRequestDTO tripRequest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return tripRepository.save(TripEntity.builder().boat(boatRepository.findById(tripRequest.boatId()).orElse(null)).patron(memberRepository.findById(tripRequest.patronId()).orElse(null)).departureDateTime(LocalDateTime.parse(tripRequest.departureDateTime(), formatter)).destination(tripRequest.destination()).build());
    }

    @Override
    public TripEntity updateTrip(Integer id, TripEntity tripEntity) {

        if (tripRepository.existsById(id)) {
            TripEntity existingTrip = tripRepository.findById(id).orElse(null);
            if (existingTrip != null) {
                existingTrip.setBoat(tripEntity.getBoat());
                existingTrip.setDepartureDateTime(tripEntity.getDepartureDateTime());
                existingTrip.setPatron(tripEntity.getPatron());
                return tripRepository.save(existingTrip);
            }
        }
        return null;

    }

    @Override
    public TripEntity getTripById(Integer id) {

        return tripRepository.findById(id).orElse(null);
    }

    @Override
    public List<TripEntity> getAllTrips() {

        return tripRepository.findAll();
    }

    @Override
    public void deleteTrip(Integer id) {

        tripRepository.deleteById(id);
    }

    @Override
    public List<TripEntity> getAllTripsByBoatId(Integer boatId) {

        return tripRepository.findAllByBoatId(boatId);
    }

    @Override
    public List<TripEntity> getAllTripsByPatronId(Integer patronId) {

        return tripRepository.findAllByPatronId(patronId);
    }

    @Override
    public TripEntity addPatronAndBoatToTrip(Integer tripId, Integer patronId, Integer boatId) {

        TripEntity existingTrip = tripRepository.findById(tripId).orElse(null);
        if (existingTrip != null) {
            existingTrip.setBoat(boatRepository.findById(boatId).orElse(null));
            existingTrip.setPatron(memberRepository.findById(patronId).orElse(null));
            return tripRepository.save(existingTrip);
        }
        return null;
        
    }

}
