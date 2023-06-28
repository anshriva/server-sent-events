package com.anubhav.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials = "true")
public class HealthCheck {
    @GetMapping("/healthCheck")
    public String healthCheck()
    {
        return "m fine!";
    }
}
