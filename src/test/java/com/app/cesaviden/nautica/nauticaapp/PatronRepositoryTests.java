package com.app.cesaviden.nautica.nauticaapp;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import com.app.cesaviden.nautica.entities.PatronEntity;
import com.app.cesaviden.nautica.repositories.PatronRepository;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PatronRepositoryTests {

    @Autowired
    private PatronRepository patronRepository;


    @Test
    @Order(1)
    @Rollback(false)
    public void testCreatePatron() {

        PatronEntity patron = new PatronEntity();
        patron.setName("Patron");
        patron.setEmail("patron@nautica");
        patron.setPhone("123456789");
        patron.setAddress("Calle Patron");
        patron.setDni("12345678A");

        assertTrue(patronRepository.save(patron) != null);
    }


    @Test
    @Order(2)
    public void testGetAllPatrons() {
        assertTrue(patronRepository.findAll().size() > 0);
    }

    @Test
    @Order(3)
    @Rollback(false)
    public void testUpdatePatronById() {

        PatronEntity patronBeforeUpdate = patronRepository.findById(1).orElse(null);
        assertNotNull(patronBeforeUpdate, "The patron exists before the update.");

        patronBeforeUpdate.setName("test2");
        patronRepository.save(patronBeforeUpdate);

        PatronEntity patronAfterUpdate = patronRepository.findById(1).orElse(null);
        assertNotNull(patronAfterUpdate, "The patron exists after the update.");

        assertEquals(patronBeforeUpdate.getName(), patronAfterUpdate.getName(), "The name of the patron was updated correctly.");
    }


    @Test
    @Order(4)
    public void testDeletePatronById() {
        patronRepository.deleteById(1);
        assertTrue(patronRepository.findById(1).isEmpty());
    }
}
