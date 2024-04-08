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
        BoatEntity boatBeforeUpdate = boatRepository.findById(1).orElse(null);

        assertNotNull(boatBeforeUpdate, "The boat exists before the update.");

        boatBeforeUpdate.setName("test2");
        boatRepository.save(boatBeforeUpdate);

        BoatEntity boatAfterUpdate = boatRepository.findById(1).orElse(null);

        assertNotNull(boatAfterUpdate, "The boat exists after the update.");

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
    public void testGetBoatByName() {
        assertTrue(boatRepository.findByName("test2").size() > 0);
    }


    @Test
    @Order(6)
    public void testGetBoatByMooringNumber() {
        assertTrue(boatRepository.findByMooringNumber(1).size() > 0);
    }

    @Test
    @Order(7)
    public void testGetAllBoatsGreaterThanFee() {
        assertTrue(boatRepository.findByFeeGreaterThan(0).size() > 0);
    }

    @Test
    @Order(8)
    public void testDeleteBoatById() {
        boatRepository.deleteById(1);
        assertTrue(boatRepository.findById(1).isEmpty());
    }

}
