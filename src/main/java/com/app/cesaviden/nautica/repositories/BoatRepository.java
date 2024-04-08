package com.app.cesaviden.nautica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.cesaviden.nautica.entities.BoatEntity;

@Repository
public interface BoatRepository extends JpaRepository<BoatEntity, Integer> {
    
    // Método para obtener todos los barcos de un propietario por su ID utilizando HQL
    List<BoatEntity> findAllByOwnerId(Integer ownerId);

    // Método para obtener un barco por su nombre
    List<BoatEntity> findByName(String name);

    // Método para obtener todos los barcos por su número de amarre
    List<BoatEntity> findByMooringNumber(Integer mooringNumber);

    // Método para obtener todos los barcos por su tarifa superior a una determinada
    List<BoatEntity> findByFeeGreaterThan(Integer fee);


}