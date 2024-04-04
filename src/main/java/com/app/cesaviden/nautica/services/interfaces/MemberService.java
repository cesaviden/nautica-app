package com.app.cesaviden.nautica.services.interfaces;

import java.util.List;

import com.app.cesaviden.nautica.entities.MemberEntity;

public interface MemberService {

    List<MemberEntity> getAllMembers();
    MemberEntity getMemberById(Integer id);
    MemberEntity createMember(MemberEntity MemberEntity);
    MemberEntity updateMember(Integer id, MemberEntity MemberEntity);
    void deleteMember(Integer id);
}
