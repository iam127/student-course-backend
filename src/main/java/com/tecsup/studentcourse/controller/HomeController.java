package com.tecsup.studentcourse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Student Course Management API");
        response.put("version", "1.0.0");
        response.put("author", "Matias Galvan Guerrero");
        response.put("status", "Running");
        response.put("endpoints", Map.of(
                "students", "/api/students",
                "courses", "/api/courses"
        ));
        return response;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("message", "API is healthy");
        return response;
    }
}