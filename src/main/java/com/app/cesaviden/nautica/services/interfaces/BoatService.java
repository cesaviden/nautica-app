package com.app.cesaviden.nautica.services.interfaces;

import java.util.List;

import com.app.cesaviden.nautica.controllers.dto.BoatCreationRequestDTO;
import com.app.cesaviden.nautica.entities.BoatEntity;

public interface BoatService {

    BoatEntity createBoat(BoatCreationRequestDTO boatRequest);
    BoatEntity updateBoat(Integer id, BoatEntity boatEntity);
    BoatEntity getBoatById(Integer id);
    List<BoatEntity> getBoatByName(String name);
    List<BoatEntity> getBoatByMooringNumber(Integer mooringNumber);
    List<BoatEntity> getBoatWithFeeGreaterThan(Integer fee);
    List<BoatEntity> getAllBoats();
    void deleteBoat(Integer id);
    List<BoatEntity> getBoatsByOwnerId(Integer ownerId);
    BoatEntity addOwnerToBoat(Integer boatId, Integer ownerId);
}
