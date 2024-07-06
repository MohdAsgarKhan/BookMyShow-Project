package com.accio.BookMyShow.Service;

import com.accio.BookMyShow.Models.*;
import com.accio.BookMyShow.Repository.MovieRepository;
import com.accio.BookMyShow.Repository.ShowRepository;
import com.accio.BookMyShow.Repository.ShowSeatRepository;
import com.accio.BookMyShow.Repository.TheaterRepository;
import com.accio.BookMyShow.Requests.AddShowRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public String addShows(AddShowRequest addShowRequest) {

        Movie movie = movieRepository.findMovieByMovieName(addShowRequest.getMovieName());
        Theater theater = theaterRepository.findById(addShowRequest.getTheaterId()).get();

        Shows shows = Shows.builder().showDate(addShowRequest.getShowDate())
                .showTime(addShowRequest.getShowTime())
                .movie(movie)
                .theater(theater).build();

        shows = showRepository.save(shows);


        //Associate the corresponding show seats with it

        List<ShowSeat> showSeatsList = new ArrayList<>(); //make arraylist to save all in DB at once

        //Step1: We get the theaterSeatList from theater Entity
        List<TheaterSeats> theaterSeatsList = theater.getTheaterSeatsList();

        //Step 2 :Iterate over the TheaterList and make show seats with it
        for(TheaterSeats theaterSeats:theaterSeatsList) {

            ShowSeat showSeat = ShowSeat.builder().seatNo(theaterSeats.getSeatNo())
                    .seatType(theaterSeats.getSeatType())
                    .isBooked(Boolean.FALSE)
                    .isFoodAttached(Boolean.FALSE)
                    .shows(shows)   //set the foregin key -parent class shows of showseat
                    .build();

            showSeatsList.add(showSeat);

        }
        //setting up the bidirectional Mapping Show to ShowSeat
        shows.setShowSeatList(showSeatsList);
        //we make list to save all at once using saveAll method
        showSeatRepository.saveAll(showSeatsList);
        return "The Shows have been added to the DB with showID "+shows.getShowId();
    }
}
