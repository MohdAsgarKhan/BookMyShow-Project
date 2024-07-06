package com.accio.BookMyShow.Models;

import com.accio.BookMyShow.Enum.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;


@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column(unique = true)
    private String movieName;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    private Double duration;
    private Double ratings;
    private LocalDate releaseDate;

}
