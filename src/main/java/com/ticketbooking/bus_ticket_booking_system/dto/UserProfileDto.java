package com.ticketbooking.bus_ticket_booking_system.dto;

import com.ticketbooking.bus_ticket_booking_system.model.Role;

import java.time.LocalDateTime;

public class UserProfileDto {
    private int userId;
    private String name;
    private String email;
    private Role role;
    private LocalDateTime createdAt;

    // Constructor
    public UserProfileDto(int userId, String name, String email, Role role, LocalDateTime createdAt) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

