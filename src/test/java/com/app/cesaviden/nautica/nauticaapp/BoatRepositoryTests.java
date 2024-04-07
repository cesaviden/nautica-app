package com.app.cesaviden.nautica.nauticaapp;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import com.app.cesaviden.nautica.entities.BoatEntity;
import com.app.cesaviden.nautica.entities.MemberEntity;
import com.app.cesaviden.nautica.repositories.BoatRepository;
import com.app.cesaviden.nautica.repositories.MemberRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BoatRepositoryTests {

    @Autowired
    private BoatRepository boatRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Order(1)
    @Rollback(false)
    public void testCreateBoat() {

        MemberEntity member = memberRepository.findById(1).orElse(null);

        List<BoatEntity> boats = new ArrayList<>();
        BoatEntity boat = new BoatEntity();
        boat.setName("test");
        boat.setFee(1);
        boat.setMooringNumber(1);
        boat.setRegistrationNumber("test1234");
        boat.setOwner(member);

        boats.add(boat);
        member.setBoats(boats);
        memberRepository.save(member);

        assertTrue(boatRepository.save(boat) != null);
    }

    @Test
    @Order(2)
    public void testGetAllBoats() {
        assertTrue(boatRepository.findAll().size() > 0);
    }

    @Test
    @Order(3)
    @Rollback(false)
    public void testUpdateBoatById() {
        // Obtener el barco de la base de datos antes de la actualización
        BoatEntity boatBeforeUpdate = boatRepository.findById(1).orElse(null);

        // Comprobar que el barco existe antes de la actualización
        assertNotNull(boatBeforeUpdate, "The boat exists before the update.");

        // Realizar la actualización del barco
        // Supongamos que se actualiza el nombre del barco

        boatBeforeUpdate.setName("test2");
        boatRepository.save(boatBeforeUpdate);

        // Volver a obtener el barco de la base de datos después de la actualización
        BoatEntity boatAfterUpdate = boatRepository.findById(1).orElse(null);

        // Comprobar que el barco existe después de la actualización
        assertNotNull(boatAfterUpdate, "The boat exists after the update.");

        // Comparar los atributos del barco antes y después de la actualización
        assertEquals(boatBeforeUpdate.getName(), boatAfterUpdate.getName(),
                "The name of the boat was updated correctly.");

    }

    @Test
    @Order(4)
    public void testGetAllBoatsByOwnerId() {
        assertTrue(boatRepository.findAllByOwnerId(1).size() > 0);
    }

    @Test
    @Order(5)
    public void testDeleteBoatById() {
        boatRepository.deleteById(1);
        assertTrue(boatRepository.findById(1).isEmpty());
    }

}
