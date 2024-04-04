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

        TripEntity existingTrip = tripRepository.findById(id).orElse(null);
        if (existingTrip != null) {
            existingTrip.setBoat(TripEntity.getBoat());
            existingTrip.setCaptainName(TripEntity.getCaptainName());
            existingTrip.setDepartureDateTime(TripEntity.getDepartureDateTime());
            existingTrip.setDestination(TripEntity.getDestination());
            return tripRepository.save(existingTrip);
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

}
