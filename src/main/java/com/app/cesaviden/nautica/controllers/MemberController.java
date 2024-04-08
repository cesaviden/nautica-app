package com.app.cesaviden.nautica.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.app.cesaviden.nautica.entities.MemberEntity;
import com.app.cesaviden.nautica.services.implementation.MemberServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/members")
@Validated
public class MemberController {

    @Autowired
    private MemberServiceImpl memberService;

    @GetMapping
    public ResponseEntity<List<MemberEntity>> getAllMembers() {
        try {
            List<MemberEntity> members = memberService.getAllMembers();
            return ResponseEntity.ok(members);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberEntity> getMemberById(@PathVariable Integer id) {
        try {
            MemberEntity member = memberService.getMemberById(id);
            return ResponseEntity.ok(member);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> createMember(@RequestBody @Valid MemberEntity memberEntity) {
        try {
            MemberEntity createdMember = memberService.createMember(memberEntity);
            return ResponseEntity.ok(createdMember);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating member: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMember(@PathVariable Integer id, @RequestBody @Valid MemberEntity memberEntity) {
        try {
            MemberEntity updatedMember = memberService.updateMember(id, memberEntity);
            return ResponseEntity.ok(updatedMember);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating member: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable Integer id) {
        try {
            memberService.deleteMember(id);
            return ResponseEntity.ok("Member deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting member: " + e.getMessage());
        }
    }
}
