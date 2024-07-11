package org.rdutta.doctorservice.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.rdutta.doctorservice.features.BMI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class DoctorService implements I_DoctorService{

    private static final Logger log = LoggerFactory.getLogger(DoctorService.class);
    @Value("${bmi.base-url}")
    private String bmiURL;
    private RestTemplate restTemplate;
    @Autowired
    public DoctorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable(value = "bmi")
    @CircuitBreaker(name = "bmiService", fallbackMethod = "fallbackMethod")
    @Override
    public ResponseEntity<?> getBMIDetails(BMI bmi) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            ObjectMapper mapper = new ObjectMapper();
            String jsonBody = mapper.writeValueAsString(bmi);
            HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);

            ResponseEntity<String> response = restTemplate.exchange(bmiURL, HttpMethod.GET, entity, String.class);
            Map<String, Object> body = mapper.readValue(response.getBody(), Map.class);
            return ResponseEntity.ok(body);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    public String fallbackMethod() {
        return "Fallback response due to: BMI Service is down.";
    }
}
