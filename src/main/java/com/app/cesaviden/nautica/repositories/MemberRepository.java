package com.app.cesaviden.nautica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.cesaviden.nautica.entities.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
}
