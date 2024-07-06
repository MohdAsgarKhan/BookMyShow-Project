package com.accio.BookMyShow.Service;

import com.accio.BookMyShow.Models.Movie;
import com.accio.BookMyShow.Repository.MovieRepository;
import com.accio.BookMyShow.Requests.AddMovieRequest;
import com.accio.BookMyShow.Requests.UpdateMovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(AddMovieRequest movieRequest) {

        //We need to save in DB entities so we will get movie entity and will save it to the DB;
        Movie movie = new Movie();
        //we make an object of movie entity and save the data from getting movie request to the movie object and saved entity to the DB
        movie.setMovieName(movieRequest.getMovieName());
        movie.setLanguage(movieRequest.getLanguage());
        movie.setDuration(movieRequest.getDuration());
        movie.setRatings(movieRequest.getRatings());
        movie.setReleaseDate(movieRequest.getReleaseDate());

        movie = movieRepository.save(movie);
        return "The movie has been added to the DB"+movie.getMovieId();
    }

    public String updateDetails(UpdateMovieRequest updateMovie) {

        //Get The Movie Entity
        Movie movie = movieRepository.findMovieByMovieName(updateMovie.getMovieName());

        //Update the movie Entity
        movie.setLanguage(updateMovie.getNewLanguage());
        movie.setRatings(updateMovie.getNewRatings());

        //Save it to the DB
        movie = movieRepository.save(movie);
        return "Updated movie details has been saved to the DB with MovieID "+movie.getMovieId();

    }
}
