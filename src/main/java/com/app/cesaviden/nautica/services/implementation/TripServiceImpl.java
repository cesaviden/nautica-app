package com.app.cesaviden.nautica.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cesaviden.nautica.entities.TripEntity;
import com.app.cesaviden.nautica.repositories.TripRepository;
import com.app.cesaviden.nautica.services.interfaces.TripService;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Override
    public TripEntity createTrip(TripEntity TripEntity) {

        return tripRepository.save(TripEntity);
    }

    @Override
    public TripEntity updateTrip(Integer id, TripEntity TripEntity) {

        if (tripRepository.existsById(id)) {
            TripEntity existingTrip = tripRepository.findById(id).orElse(null);
            if (existingTrip != null) {
                existingTrip.setBoat(TripEntity.getBoat());
                existingTrip.setDepartureDateTime(TripEntity.getDepartureDateTime());
                existingTrip.setPatron(TripEntity.getPatron());
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
    public TripEntity addPatronAndBoatToTrip(TripEntity tripEntity, Integer patronId, Integer boatId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPatronAndBoatToTrip'");
    }

}
