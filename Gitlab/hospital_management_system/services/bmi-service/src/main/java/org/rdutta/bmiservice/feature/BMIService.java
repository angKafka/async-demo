package org.rdutta.bmiservice.feature;

import com.fasterxml.jackson.databind.ObjectMapper;


import org.rdutta.bmiservice.entity.BMI;
import org.rdutta.bmiservice.exception.BMIException;
import org.rdutta.bmiservice.service.I_BMIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;



import java.util.Map;

@Service
public class BMIService implements I_BMIService {
    private static final Logger log = LoggerFactory.getLogger(BMIService.class);
    @Value("${bmi.url}")
    private String url;
    @Value("${bmi.x-rapidapi-key}")
    private String XRapidAPIKey;
    @Value("${bmi.x-rapidapi-host}")
    private String XRapidAPIHost;
    @Value("${bmi.content-Type}")
    private String contentType;
    private RestTemplate restTemplate;

    @Autowired
    public BMIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public Object getBMI(BMI bmi) throws BMIException {
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-RapidAPI-Key", XRapidAPIKey);
            headers.set("X-RapidAPI-Host", XRapidAPIHost);
            headers.set("Content-Type", contentType);

            ObjectMapper objectMapper = new ObjectMapper();
            String bmiJson = objectMapper.writeValueAsString(bmi);

            HttpEntity<String> entity = new HttpEntity<>(bmiJson, headers);
            //TODO: Call the Endpoint
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            Map<String, Object> jsonResponse = objectMapper.readValue(response.getBody(), Map.class);
            return jsonResponse;
        } catch (Exception exception) {
            log.error("Error occurred while fetching BMI data: {}", exception.getMessage(), exception);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error occurred while fetching BMI data",
                    exception
            );
        }
    }
}
