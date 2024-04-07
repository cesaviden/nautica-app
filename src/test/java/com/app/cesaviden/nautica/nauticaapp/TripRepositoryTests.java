package com.app.cesaviden.nautica.nauticaapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.cesaviden.nautica.entities.BoatEntity;
import com.app.cesaviden.nautica.entities.PatronEntity;
import com.app.cesaviden.nautica.entities.TripEntity;
import com.app.cesaviden.nautica.repositories.BoatRepository;
import com.app.cesaviden.nautica.repositories.PatronRepository;
import com.app.cesaviden.nautica.repositories.TripRepository;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TripRepositoryTests {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private BoatRepository boatRepository;
    
    @Autowired
    private PatronRepository patronRepository;

    @Test
    @Order(1)
    @Rollback(false)
    public void testCreateTrip() {

        PatronEntity patron = patronRepository.findById(1).orElse(null);

        BoatEntity boat = boatRepository.findById(1).orElse(null);

        TripEntity TripEntity = new TripEntity();
        TripEntity.setBoat(boat);
        TripEntity.setPatron(patron);
        TripEntity.setDestination("Barcelona");

        // Convert the String to LocalDateTime
        String departureDateTimeString = "2022-01-01 10:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime departureDateTime = LocalDateTime.parse(departureDateTimeString, formatter);

        TripEntity.setDepartureDateTime(departureDateTime);

        assertTrue(tripRepository.save(TripEntity) != null);
    }

    @Test
    @Order(2)
    public void testGetAllTrips() {
        assertTrue(tripRepository.findAll().size() > 0);
    }

    @Test
    @Order(3)
    public void testGetTripsByPatronId() {
        assertTrue(tripRepository.findAllByPatronId(1).size() > 0);
    }

    @Test
    @Order(4)
    public void testGetAllTripsByBoatId() {
        assertTrue(tripRepository.findAllByBoatId(1).size() > 0);
    }

    @Test
    @Order(5)
    @Rollback(false)
    public void testUpdateTripById() {
        TripEntity trip = tripRepository.findById(1).orElse(null);
        assertNotNull(trip, "The trip exists before the update.");
        trip.setDestination("Madrid");
        tripRepository.save(trip);

        TripEntity updatedTrip = tripRepository.findById(1).orElse(null);
        assertNotNull(updatedTrip, "The trip exists after the update.");
        assertEquals("Madrid", updatedTrip.getDestination(), "The destination of the trip was updated correctly.");
    }

    @Test
    @Order(6)
    public void testDeleteTripById() {
        TripEntity trip = tripRepository.findById(1).orElse(null);
        assertNotNull(trip, "The trip exists before the deletion.");
        tripRepository.deleteById(1);
        assertTrue(tripRepository.findById(1).isEmpty(), "The trip was deleted successfully.");
    }

}
