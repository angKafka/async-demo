package org.rdutta.mailserver.user;


import org.rdutta.mailserver.record.MemberResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class UserClient {

    @Value("${app.config.user-url}")
    private String userURI;
    private RestTemplate restTemplate;

    public UserClient() {}

    public UserClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

   public MemberResponse findMemberByMemberUUID(UUID member_id){
       Logger logger = LoggerFactory.getLogger(UserClient.class);
       String url = String.format("%s/%s", userURI, member_id);
       logger.info("Fetching member details for member UUID: {}", member_id);

       try {
           ResponseEntity<MemberResponse> response = restTemplate.getForEntity(url, MemberResponse.class);
           logger.info("Successfully fetched member details for member UUID: {}", member_id);
           return response.getBody();
       } catch (Exception e) {
           logger.error("Failed to fetch member details for member UUID: {}", member_id, e);
           return null;
       }
   }
}
