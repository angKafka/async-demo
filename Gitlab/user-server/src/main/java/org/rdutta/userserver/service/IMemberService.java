package org.rdutta.userserver.service;

import org.rdutta.userserver.entity.Member;
import org.rdutta.userserver.record.MemberRequest;
import org.rdutta.userserver.record.MemberResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface IMemberService {
    UUID createMember(MemberRequest memberRequest);
    void updateMember(UUID member_id, MemberRequest memberRequest);
    void deleteByMemberID(UUID member_id);
    MemberResponse getMember(UUID member_id);
    List<MemberResponse> getMembers();
    void sendMail(String subject, String content, String to) throws IOException;
}
