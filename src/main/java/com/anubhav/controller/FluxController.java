package com.anubhav.controller;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/flux")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials = "true")
public class FluxController {


    @GetMapping("/users")
    public Flux<ServerSentEvent<List<String>>> streamUsers() {
        return this.getUsers();
    }

    public Flux<ServerSentEvent<List<String>>> getUsers() {
        List<String> users = Arrays.asList("anubhav", "anubhav", "arun");
        return Flux
                .interval(Duration.ofSeconds(1))
                .map(sequence -> ServerSentEvent.<List<String>>builder()
                        .id(String.valueOf(sequence))
                        .data(users)
                        .build());
    }
}
