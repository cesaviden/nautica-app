package com.app.cesaviden.nautica.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cesaviden.nautica.entities.PatronEntity;
import com.app.cesaviden.nautica.repositories.PatronRepository;
import com.app.cesaviden.nautica.services.interfaces.PatronService;

@Service
public class PatronServiceImpl implements PatronService {

    @Autowired
    private PatronRepository patronRepository;

    @Override
    public List<PatronEntity> getAllPatrons() {
        return patronRepository.findAll();
    }

    @Override
    public PatronEntity createPatron(PatronEntity patron) {
        return patronRepository.save(patron);
    }

    @Override
    public void deletePatron(Integer id) {
        
        patronRepository.deleteById(id);
    }

    @Override
    public PatronEntity getPatronById(Integer id) {
        
        return patronRepository.findById(id).orElse(null);
    }

    @Override
    public PatronEntity updatePatron(Integer id ,PatronEntity patron) {

        PatronEntity existingPatron = patronRepository.findById(id).orElse(null);

        if (existingPatron != null) {
            existingPatron.setName(patron.getName());
            existingPatron.setEmail(patron.getEmail());
            existingPatron.setPhone(patron.getPhone());
            existingPatron.setAddress(patron.getAddress());
            return patronRepository.save(existingPatron);
        }

        return null;

    }

    

}
