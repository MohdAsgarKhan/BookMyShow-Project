package com.accio.BookMyShow.Models;

import jakarta.annotation.security.DenyAll;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "TicketBooking")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ticketId;

    private String bookedSeats;
    private String movieName;
    private String theaterName;
    private LocalDate showDate;
    private LocalTime  showTime;

    private Integer totalAmount;

    @JoinColumn
    @ManyToOne
    private Shows shows;

    @JoinColumn
    @ManyToOne
    private User user;

}
