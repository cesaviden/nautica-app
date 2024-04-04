package com.app.cesaviden.nautica.services.interfaces;

import java.util.List;

import com.app.cesaviden.nautica.entities.TripEntity;

public interface TripService {

    TripEntity createTrip(TripEntity TripEntity);
    TripEntity updateTrip(Integer id, TripEntity TripEntity);
    TripEntity getTripById(Integer id);
    List<TripEntity> getAllTrips();
    void deleteTrip(Integer id);

}
