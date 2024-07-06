package com.accio.BookMyShow.Models;

import com.accio.BookMyShow.Enum.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class TheaterSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterSeatId;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private String seatNo;

    @JoinColumn
    @ManyToOne
    private Theater theater;
}
