package com.JoaquinDeLosada.spring_data.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    // Returns the currently logged-in user's info
    @GetMapping("/me")
    public Map<String, String> me(Authentication auth) {
        var role = auth.getAuthorities().iterator().next().getAuthority();
        return Map.of("username", auth.getName(), "role", role);
    }

    // User-only endpoint
    @GetMapping("/user/dashboard")
    public Map<String, String> userDashboard() {
        return Map.of("message", "Welcome to the user dashboard!");
    }

    // Admin-only endpoint
    @GetMapping("/admin/panel")
    public Map<String, String> adminPanel() {
        return Map.of("message", "Welcome to the admin panel!");
    }
}
