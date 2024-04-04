package com.app.cesaviden.nautica.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.cesaviden.nautica.entities.BoatEntity;
import com.app.cesaviden.nautica.entities.MemberEntity;

public interface BoatRepository extends JpaRepository<BoatEntity, Integer> {
    
    Optional<BoatEntity> findAllByOwner(MemberEntity owner);
}