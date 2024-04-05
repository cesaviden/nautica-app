package com.app.cesaviden.nautica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.app.cesaviden.nautica.entities.BoatEntity;
import java.util.Optional;

@Repository
public interface BoatRepository extends JpaRepository<BoatEntity, Integer> {
    
    // Método para obtener todos los barcos de un propietario por su ID utilizando HQL
    @Query("SELECT b FROM BoatEntity b WHERE b.owner.id = :ownerId")
    Optional<BoatEntity> findAllByOwnerId(Integer ownerId);
}