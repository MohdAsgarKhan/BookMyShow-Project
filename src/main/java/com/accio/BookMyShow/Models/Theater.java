package com.accio.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterId;

    private String theaterName;
    private Integer noOfScreens;
    private String address;


    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    List<TheaterSeats> theaterSeatsList = new ArrayList<>();
}
