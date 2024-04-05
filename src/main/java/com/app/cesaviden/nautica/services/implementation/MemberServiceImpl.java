package com.app.cesaviden.nautica.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cesaviden.nautica.entities.MemberEntity;
import com.app.cesaviden.nautica.repositories.MemberRepository;
import com.app.cesaviden.nautica.services.interfaces.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public MemberEntity createMember(MemberEntity MemberEntity) {
        return memberRepository.save(MemberEntity);
    }

    @Override
    public MemberEntity updateMember(Integer id ,MemberEntity MemberEntity) {
        MemberEntity existingMember = memberRepository.findById(id).orElse(null);
        if (existingMember != null) {
            existingMember.setName(MemberEntity.getName());
            existingMember.setAddress(MemberEntity.getAddress());
            existingMember.setDni(MemberEntity.getDni());
            existingMember.setPhone(MemberEntity.getPhone());
            existingMember.setEmail(MemberEntity.getEmail());
            return memberRepository.save(existingMember);
        }
        
        return null;
    }

    @Override
    public MemberEntity getMemberById(Integer id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public List<MemberEntity> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void deleteMember(Integer id) {
        memberRepository.deleteById(id);
    }

}
