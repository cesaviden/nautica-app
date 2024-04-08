package com.app.cesaviden.nautica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.cesaviden.nautica.entities.TripEntity;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<TripEntity, Integer> {
    
    // Método para obtener todas las salidas de un barco por su ID
    List<TripEntity> findAllByBoatId(Integer boatId);

    // Método para obtener todas las salidas de un patrón por su ID
    List<TripEntity> findAllByPatronId(Integer patronId);

    // Método para obtener todas las salidas entre dos fechas
    List<TripEntity> findByDepartureDateTimeBetween(LocalDateTime start, LocalDateTime end);

}