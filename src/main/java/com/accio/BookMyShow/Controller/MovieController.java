package com.accio.BookMyShow.Controller;

import com.accio.BookMyShow.Models.Movie;
import com.accio.BookMyShow.Requests.AddMovieRequest;
import com.accio.BookMyShow.Requests.UpdateMovieRequest;
import com.accio.BookMyShow.Service.MovieService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")

public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping ("add")
    public ResponseEntity addMovie(@RequestBody AddMovieRequest movieRequest) {

        String response = movieService.addMovie(movieRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity updateDetails(@RequestBody UpdateMovieRequest updateMovie) {

        String response = movieService.updateDetails(updateMovie);
        return new ResponseEntity(response, HttpStatus.OK);

    }
}
