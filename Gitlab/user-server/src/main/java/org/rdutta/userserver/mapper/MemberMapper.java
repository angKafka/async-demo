package org.rdutta.userserver.mapper;

import org.rdutta.userserver.entity.Member;
import org.rdutta.userserver.record.MemberRequest;
import org.rdutta.userserver.record.MemberResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class MemberMapper {
    public Member toMember(MemberRequest memberRequest) {
        if(memberRequest == null){
            return null;
        }
        System.out.println("MemberRequest: " + memberRequest);
        Member member = new Member(
                memberRequest.username(),
                memberRequest.email(),
                memberRequest.password(),
                memberRequest.active()
        );
        System.out.println("Member: " + member);
        return member;
    }

    public MemberResponse toMemberResponse(Member member) {
        return new MemberResponse(
                member.getMember_id(),
                member.getUsername(),
                member.getEmail(),
                member.getPassword()
        );
    }
}
