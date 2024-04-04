package com.app.cesaviden.nautica.services.interfaces;

import java.util.List;

import com.app.cesaviden.nautica.entities.BoatEntity;

public interface BoatService {

    BoatEntity createBoat(BoatEntity boatEntity);
    BoatEntity updateBoat(Integer id, BoatEntity boatEntity);
    BoatEntity getBoatById(Integer id);
    List<BoatEntity> getAllBoats();
    void deleteBoat(Integer id);

}
