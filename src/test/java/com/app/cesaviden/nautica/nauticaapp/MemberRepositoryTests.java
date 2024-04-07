package com.app.cesaviden.nautica.nauticaapp;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import com.app.cesaviden.nautica.entities.MemberEntity;
import com.app.cesaviden.nautica.repositories.MemberRepository;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Order(1)
    @Rollback(false)
    public void testCreateMember() {
        
        MemberEntity member = new MemberEntity();

        member.setName("test");
        member.setAddress("test");
        member.setDni("test");
        member.setPhone("test");
        member.setEmail("test@gmail.com");

        assertTrue(memberRepository.save(member) != null);
    }

    @Test
    @Order(2)
    public void testGetAllMembers() {
        assertTrue(memberRepository.findAll().size() > 0);
    }

    @Test
    @Order(3)
    @Rollback(false)
    public void testUpdateMemberById() {

        MemberEntity memberBeforeUpdate = memberRepository.findById(1).orElse(null);
        assertNotNull(memberBeforeUpdate, "The member exists before the update.");

        memberBeforeUpdate.setName("test2");
        memberRepository.save(memberBeforeUpdate);

        MemberEntity memberAfterUpdate = memberRepository.findById(1).orElse(null);
        assertNotNull(memberAfterUpdate, "The member exists after the update.");

        assertEquals(memberBeforeUpdate.getName(), memberAfterUpdate.getName(), "The name of the member was updated correctly.");

    }

    @Test
    @Order(4)
    @Rollback(false)
    public void testDeleteMemberById() {
        memberRepository.deleteById(1);
        assertTrue(memberRepository.findById(1).isEmpty());
    }
}
