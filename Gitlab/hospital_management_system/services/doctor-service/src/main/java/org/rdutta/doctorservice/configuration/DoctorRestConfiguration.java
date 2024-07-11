package org.rdutta.doctorservice.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DoctorRestConfiguration {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder templateBuilder){
        return templateBuilder.build();
    }
}
