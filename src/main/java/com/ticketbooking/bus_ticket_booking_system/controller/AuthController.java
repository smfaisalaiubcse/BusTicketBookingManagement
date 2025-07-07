package com.ticketbooking.bus_ticket_booking_system.controller;

import com.ticketbooking.bus_ticket_booking_system.dto.UserSignupRequest;
import com.ticketbooking.bus_ticket_booking_system.model.User;
import com.ticketbooking.bus_ticket_booking_system.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> signup(@Valid @RequestBody UserSignupRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        authService.signup(user);

        return ResponseEntity.ok(Map.of("message", "User registered successfully."));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) {
        String token = authService.login(user.getEmail(), user.getPassword());
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }
}
