package com.app.cesaviden.nautica.services.interfaces;

import java.util.List;

import com.app.cesaviden.nautica.entities.PatronEntity;

public interface PatronService {

    List<PatronEntity> getAllPatrons();
    PatronEntity createPatron(PatronEntity patron);
    void deletePatron(Integer id);
    PatronEntity getPatronById(Integer id);
    PatronEntity updatePatron(Integer id,PatronEntity patron);

}
