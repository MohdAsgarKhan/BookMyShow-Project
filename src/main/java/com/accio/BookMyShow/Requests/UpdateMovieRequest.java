package com.accio.BookMyShow.Requests;

import com.accio.BookMyShow.Enum.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class UpdateMovieRequest {
    private String movieName;

    //we can name anything
    private Language newLanguage;
    private Double newRatings;
}
