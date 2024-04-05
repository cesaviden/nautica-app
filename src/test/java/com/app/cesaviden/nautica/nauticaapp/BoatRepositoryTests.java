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

        MemberEntity member = new MemberEntity();

        member.setName("test");
        member.setAddress("test");
        member.setDni("test");
        member.setPhone("test");
        member.setEmail("test@gmail.com");

        List<BoatEntity> boats = new ArrayList<>();
        BoatEntity boat = new BoatEntity(null, "test1234F", "test", 1, 1, null);
        boats.add(boat);
        member.setBoats(boats);
        memberRepository.save(member);
        boat.setOwner(member); 

        assertTrue(boatRepository.save(boat) != null);
    }


    @Test
    @Order(3)
    public void testGetAllBoats() {
        assertTrue(boatRepository.findAll().size() > 0);
    }

    @Test
    @Order(4)
    public void testGetBoatById() {
        assertTrue(boatRepository.findById(1).isPresent());
    }

    @Test
    @Order(5)
    public void testGetAllBoatsByOwnerId() {
        assertTrue(boatRepository.findAllByOwnerId(1).size() > 0);
    }

}
