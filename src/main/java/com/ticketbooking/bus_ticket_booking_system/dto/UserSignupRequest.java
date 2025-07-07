package com.ticketbooking.bus_ticket_booking_system.dto;

import com.ticketbooking.bus_ticket_booking_system.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserSignupRequest {

    @NotBlank(message = "Name is required.")
    private String name;

    @Email(message = "Invalid email format.")
    @NotBlank(message = "Email is required.")
    private String email;

    @Size(min = 8, message = "Password must be at least 8 characters.")
    private String password;

    private Role role; // optional; can default if null

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}