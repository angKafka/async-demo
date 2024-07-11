package org.rdutta.springtutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;

@RestController
public class GreetController {

    @Value("${home.name}")
    private String name;
    @GetMapping("/")
    public String greet() {
        return String.format("Hello %s!", name)+"\n\n"+Date.from(Instant.now());
    }

    @GetMapping("/workout")
    public String greetWorkout() {
        return String.format("workout %s!", name);
    }
}
