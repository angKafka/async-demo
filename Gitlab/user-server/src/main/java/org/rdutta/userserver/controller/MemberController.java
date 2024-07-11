package org.rdutta.userserver.controller;

import jakarta.validation.Valid;
import org.rdutta.userserver.implementation.MemberService;
import org.rdutta.userserver.record.MemberRequest;
import org.rdutta.userserver.record.MemberResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/users")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(path = "/register")
    public ResponseEntity<UUID> createMember(@RequestBody MemberRequest memberRequest) throws IOException {
        String content = "Hello,\nThanks for registering yourself.";
        String subject = "New user - in record";
        String to = memberRequest.email();
        if(memberRequest.email() != null && !memberRequest.email().isEmpty()) {
            memberService.sendMail(subject, content, to);
        }
        return ResponseEntity.ok(memberService.createMember(memberRequest));
    }

    @PutMapping(path = "/{member_id}")
    public ResponseEntity<Void> updateMember(@PathVariable("member_id") UUID member_id, @RequestBody MemberRequest memberRequest) {
        memberService.updateMember(member_id,memberRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{member_id}")
    public ResponseEntity<MemberResponse> findMemberByMemberUUID(@PathVariable("member_id") UUID member_id) {
        MemberResponse memberResponse = memberService.getMember(member_id);
        return ResponseEntity.ok(memberResponse);
    }

    @DeleteMapping(path = "/{member_id}")
    public ResponseEntity<Void> deleteMemberByMemberID(@PathVariable("member_id") UUID member_id) {
        memberService.deleteByMemberID(member_id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<MemberResponse>> findAllMembers() {
        List<MemberResponse> members = memberService.getMembers();
        return ResponseEntity.ok(members);
    }
}
