package org.rdutta.userserver.implementation;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.transaction.Transactional;
import okhttp3.*;
import org.rdutta.userserver.entity.Member;
import org.rdutta.userserver.exception.MemberException;
import org.rdutta.userserver.mapper.MemberMapper;
import org.rdutta.userserver.record.MemberRequest;
import org.rdutta.userserver.record.MemberResponse;
import org.rdutta.userserver.repository.MemberRepository;
import org.rdutta.userserver.service.IMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MemberService implements IMemberService {
    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    private static String token = "EwBwA8l6BAAUbDba3x2OMJElkF7gJ4z/VbCPEz0AAe/ehFZb29utEcqD6O2gRWQ3bcvRgQtGrcbZJb5vqUSY8/1TnxOMvs03Zv4Eva2sqiKjarqU7guF6SoVsfOyiHDrrRw/U/N0TeyYg/mmWEaJCt0oBJXMcKphu97GUWz+TDodB6JA812SAyADvripBqUUnEPiQLg6D3bpWt/DrGH/TH/D5DqBtvBVdTcr1UO6lwnhPk25MFPP9P2aVpW1bt7fp4jZzH90CpwwSU/VO+ouAVnLjiurLwsmPTnHn4P4uF3dcJNeejfALHvlf/LycO5lWFl/WFfErARznW3aIGOx8rYx84fSNlWiOCACSpeyZFbSKbDtkXG1Ss6M8Tkc3i8DZgAACFpKrBOvUMsHQAIuckSTepB+XfQH43IU6HjEB2NSlBCRTNJhF4rBO4KzladI5CQxPx0XCmFzz2mfWD3tsBSxTdAJG0CRKjiFB7A89s2/SnX3UKEub3u2OMQhElKatJKpfpYIb1oVTcZ4nm/aDWQMiP3xB2swFLwe9JWgRaIHALLBZlvd4Blc84ZXiJHY4SnSjasLFzvzFvaaDYb98Oo2iFDf/9dBoSW83xum/zFl/CNvhAXxv4VdWt19eT5EJDvETx9uRuVwTr13Al7cfyTxtnYvkAkqYS5CFn67u3s9xT3HL7+edCbknvx1Ef1tphIaMdym0HQZwdNtdZyK+zcOP2+Yu+4zANkyGIw9F3oxSzljh76W7nNDHcGYnfyfM6gVmcBJ5DfEFHv+NjiyyvRx5r+c5+ryqw46f1k5Sgb3vO2fbXusQc9AS7r6eLpYxARqngbFS3Vi4DtKbTuRvDQS5idE0brPlnLnD060sHPKOF42qca7+fPNmf0uh3V9eaQpnPiBvgfnTFY/ikzRG9rzuXIaQogsnT7EGN9842yp/GoCyah2VQpaK3eaEsXfu73uxvtzP8Tw8/VA4gSUlQ7HyNfQ6KSCPLZdqcPw5nxgl+dVOHDqF8cj00VwWv9NWuu1dCqk5JaktPWq82xlfXSQ/+sChwFCkPhHGPAE7RmyjUIAScWTKQNjQ1qH1WaP+xUXPUUbzWvbDhr+ADWTyz9IApoznbkQzMQIp5KTbtG3aUGjkipSKOfIE5geyjv2YPFhnkETiAW+gZxQvdh6Ag==";
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberService(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    @Transactional
    @Override
    public UUID createMember(MemberRequest memberRequest) {
        Member member = memberMapper.toMember(memberRequest);
       return memberRepository.save(member).getMember_id();
    }

    @Transactional
    @Override
    public void updateMember(UUID member_id, MemberRequest memberRequest) {
        Member existMember = memberRepository.findById(member_id).orElseThrow(() -> new MemberException("user by id"+ member_id + " was not found."));

        existMember.setUsername(memberRequest.username());
        existMember.setEmail(memberRequest.email());
        existMember.setActive(memberRequest.active());

        Member updatedProvider = memberRepository.save(existMember);

        memberRepository.save(updatedProvider);

    }



    @Transactional
    @Override
    @CacheEvict(value = "member", key = "#member_id")
    public void deleteByMemberID(UUID member_id) {
        if (member_id != null) {
            var member = memberRepository.findById(member_id);
            if (member.isPresent()) {
                Member member_delete = member.get();
                memberRepository.delete(member_delete);
            } else {
                throw new MemberException("Member not found");
            }
        } else {
            throw new MemberException("Member ID cannot be null");
        }
    }


    @Cacheable(value = "member", key = "#member_id")
    @Override
    public MemberResponse getMember(UUID member_id) {
        return memberRepository.findById(member_id).map(memberMapper::toMemberResponse).orElseThrow(()->new MemberException(String.format("Member not found with id: {}", member_id)));
    }

    @Cacheable(value = "member")
    @Override
    public List<MemberResponse> getMembers() {
        return memberRepository.findAll().stream().map(memberMapper::toMemberResponse).collect(Collectors.toList());
    }

    @CircuitBreaker(name = "emailService", fallbackMethod = "sendMailFallback")
    @Override
    public void sendMail(String subject, String content, String to) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"message\": {\n        \"subject\": \""+subject+"\",\n        \"body\": {\n            \"contentType\": \"Text\",\n            \"content\": \""+content+"\"\n        },\n        \"toRecipients\": [\n            {\n                \"emailAddress\": {\n                    \"address\": \""+to+"\"\n                }\n            }\n        ]\n    },\n        \"saveToSentItems\": \"false\"\n}");
        Request request = new Request.Builder()
                .url("https://graph.microsoft.com/v1.0/me/sendMail")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", token)
                .build();
        Response response = client.newCall(request).execute();

        System.out.println("Successfully user got create!");
    }

    public void sendMailFallback(String subject, String content, String to, IOException ex) {
        logger.warn("Circuit breaker opened for sending email to {}: {}", to, ex.getMessage());
        String fallbackContent = "Hello,\nYour email could not be sent at this time.";
        String fallbackSubject = "Email Delivery Issue";
        try {
            sendFallbackEmail(fallbackSubject, fallbackContent, to);
        } catch (IOException fallbackEx) {
            logger.error("Failed to send fallback email to {}: {}", to, fallbackEx.getMessage());
        }
    }

    private void sendFallbackEmail(String subject, String content, String to) throws IOException {
        logger.info("Sending fallback email to {}: {}", to, subject);
    }
}
