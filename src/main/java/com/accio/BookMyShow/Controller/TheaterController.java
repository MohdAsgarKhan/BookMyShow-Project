package com.accio.BookMyShow.Controller;

import com.accio.BookMyShow.Requests.AddTheaterRequest;
import com.accio.BookMyShow.Requests.AddTheaterSeatRequest;
import com.accio.BookMyShow.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/add")
    public ResponseEntity addTheater(@RequestBody AddTheaterRequest addTheaterRequest) {

        String response = theaterService.addTheater(addTheaterRequest);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping ("associateTheraterSeats")
    public ResponseEntity associateTheaterSeats(@RequestBody AddTheaterSeatRequest addTheaterSeatRequest) {
        String response = theaterService.associateTheaterSeats(addTheaterSeatRequest);

        return new ResponseEntity(response, HttpStatus.OK);

    }

}
