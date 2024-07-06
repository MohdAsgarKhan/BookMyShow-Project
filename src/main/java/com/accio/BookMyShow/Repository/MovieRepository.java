package com.accio.BookMyShow.Repository;

import com.accio.BookMyShow.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    //If there is no JPA inbuilt method is there then we can use our custom method and we can use it
    //JPA allows that

    //We have define method to get movie entity from movieName;
    Movie findMovieByMovieName(String movieName);


}
