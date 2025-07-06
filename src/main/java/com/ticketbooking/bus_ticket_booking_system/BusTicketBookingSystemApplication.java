package com.ticketbooking.bus_ticket_booking_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.ticketbooking.bus_ticket_booking_system.model")
@EnableJpaRepositories("com.ticketbooking.bus_ticket_booking_system.repository")
public class BusTicketBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusTicketBookingSystemApplication.class, args);
	}

}
