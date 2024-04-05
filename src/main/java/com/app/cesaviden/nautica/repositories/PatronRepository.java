package com.app.cesaviden.nautica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.cesaviden.nautica.entities.PatronEntity;

public interface PatronRepository extends JpaRepository<PatronEntity, Integer> {
}
