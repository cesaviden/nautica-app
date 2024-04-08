package com.app.cesaviden.nautica.services.interfaces;

import java.util.List;

import com.app.cesaviden.nautica.controllers.dto.TripCreationRequestDTO;
import com.app.cesaviden.nautica.entities.TripEntity;

public interface TripService {

    TripEntity createTrip(TripCreationRequestDTO TripEntity);
    TripEntity updateTrip(Integer id, TripEntity TripEntity);
    TripEntity getTripById(Integer id);
    List<TripEntity> getAllTrips();
    List<TripEntity> getAllTripsByBoatId(Integer boatId);
    List<TripEntity> getAllTripsByPatronId(Integer patronId);
    void deleteTrip(Integer id);
    TripEntity addPatronAndBoatToTrip(Integer tripId, Integer patronId, Integer boatId);
}
