package com.accio.BookMyShow.Requests;

import com.accio.BookMyShow.Enum.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMovieRequest {

    private String movieName;
    private Language language;
    private Double duration;
    private Double ratings;
    private LocalDate releaseDate;
}
