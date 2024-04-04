package com.app.cesaviden.nautica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.cesaviden.nautica.entities.MemberEntity;
import com.app.cesaviden.nautica.services.implementation.MemberServiceImpl;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberServiceImpl memberService;

    @GetMapping
    public ResponseEntity<List<MemberEntity>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberEntity> getMemberById(@RequestParam Integer id) {
        return ResponseEntity.ok(memberService.getMemberById(id));
    }
    
    @PostMapping
    public ResponseEntity<MemberEntity> createMember(@RequestBody @Valid MemberEntity memberEntity) {
        return ResponseEntity.ok(memberService.createMember(memberEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberEntity> updateMember(@RequestParam Integer id, @RequestBody @Valid  MemberEntity memberEntity) {
        return ResponseEntity.ok(memberService.updateMember(id, memberEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@RequestParam Integer id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok().build();
    }
    

}