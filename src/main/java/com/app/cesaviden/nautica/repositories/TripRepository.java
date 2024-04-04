package com.app.cesaviden.nautica.repositories;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.cesaviden.nautica.entities.BoatEntity;
import com.app.cesaviden.nautica.entities.TripEntity;

public interface TripRepository extends JpaRepository<TripEntity, Integer> {

    Optional<TripEntity> findByBoat(BoatEntity boat);
    Optional<TripEntity> findByDepartureDateTimeBefore(LocalDateTime dateTime);
    Optional<TripEntity> findByDepartureDateTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

}
