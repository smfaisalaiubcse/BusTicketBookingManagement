package com.ticketbooking.bus_ticket_booking_system.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

// Global exception handler
@ControllerAdvice
public class ExceptionHandlerAspect {
    // Handle validation errors (e.g., @Valid input failures)
    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(org.springframework.web.bind.MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // Handle generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse("Internal Server Error", ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handle runtime exceptions (like the ones thrown in your services such as "Invalid credentials!")
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse("Bad Request", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    // You can add additional handlers for more specific exceptions (e.g., database-related, JWT validation, etc.)

    // Inner class to format the error response
    public static class ErrorResponse {
        private String error;
        private String message;

        public ErrorResponse(String error, String message) {
            this.error = error;
            this.message = message;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}