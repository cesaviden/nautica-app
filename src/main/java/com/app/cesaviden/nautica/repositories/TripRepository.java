package com.app.cesaviden.nautica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.cesaviden.nautica.entities.TripEntity;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<TripEntity, Integer> {
    
    // Método para obtener todas las salidas de un barco por su ID
    @Query("SELECT t FROM TripEntity t WHERE t.boat.id = :boatId")
    List<TripEntity> findAllByBoatId(Integer boatId);

    // Método para obtener todas las salidas de un patrón por su ID
    @Query("SELECT t FROM TripEntity t WHERE t.patron.id = :patronId")
    List<TripEntity> findAllByPatronId(Integer patronId);
}