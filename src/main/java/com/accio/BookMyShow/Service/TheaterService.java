package com.accio.BookMyShow.Service;

import com.accio.BookMyShow.Enum.SeatType;
import com.accio.BookMyShow.Models.Theater;
import com.accio.BookMyShow.Models.TheaterSeats;
import com.accio.BookMyShow.Repository.TheaterRepository;
import com.accio.BookMyShow.Repository.TheaterSeatRepository;
import com.accio.BookMyShow.Requests.AddTheaterRequest;
import com.accio.BookMyShow.Requests.AddTheaterSeatRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterSeatRepository theaterSeatRepository;

    public String addTheater(AddTheaterRequest addTheaterRequest) {

        //we need Theater entity and save to the Db entity
        //we make object of theater class
        Theater theater = new Theater();

        theater.setTheaterName(addTheaterRequest.getTheaterName());
        theater.setAddress(addTheaterRequest.getAddress());
        theater.setNoOfScreens(addTheaterRequest.getNoOfScreens());

        //save it to the DB
        theater = theaterRepository.save(theater);

        return "Theater request has been added to the DB with TheaterID "+theater.getTheaterId();
    }

    public String associateTheaterSeats(AddTheaterSeatRequest addTheaterSeatRequest) {

        List<TheaterSeats> theaterSeatsList = new ArrayList<>();
        //we will save all seatNo in arraylist in DB
        int theaterId = addTheaterSeatRequest.getTheaterSeatId();
        int noOfClassicSeats = addTheaterSeatRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = addTheaterSeatRequest.getNoOfPremiumSeats();

        //Get the theater entity from the DB
        Theater theater = theaterRepository.findById(theaterId).get();

        //Generate the SeatNumber through For/while Loop
        int row;
        int noOfRowsOfClassicSeats = noOfClassicSeats/5;
        int noOfSeatsInLastRowClassic = noOfClassicSeats%5;

        for(row = 1; row<=noOfRowsOfClassicSeats;row++) {

            for(int j =1;j<=5;j++) {
                char ch = (char)('A'+j-1);
                String seatNumber = ""+row+ch;

                TheaterSeats theaterSeats = TheaterSeats.builder().seatNo(seatNumber)
                        .seatType(SeatType.CLASSIC).theater(theater).build();

                //It is mandatory to add parent class entity in builder as foreign Key;

                //adding to the list
                theaterSeatsList.add(theaterSeats);

            }
        }
        //for last row
        for(int j =1;j<=noOfSeatsInLastRowClassic;j++) {
            char ch = (char)('A'+j-1);
            String seatNumber = ""+row+ch;

            TheaterSeats theaterSeats = TheaterSeats.builder().seatNo(seatNumber)
                    .seatType(SeatType.CLASSIC).theater(theater).build();

            //It is mandatory to add parent class entity in builder as foreign Key;

            //adding to the list
            theaterSeatsList.add(theaterSeats);
        }

        //we will use same code for
        int noOfRowsOfPremiumSeats = noOfPremiumSeats/5;
        int noOfSeatsInLastRowPremium = noOfPremiumSeats%5;

        int currentRow = row;
        if(noOfSeatsInLastRowClassic>0){
            currentRow++;
        }
        for(row=currentRow;row<=noOfRowsOfPremiumSeats+currentRow-1; row++) {

            for(int j =1;j<=5;j++) {
                char ch = (char)('A'+j-1);
                String seatNumber = ""+row+ch;

                TheaterSeats theaterSeats = TheaterSeats.builder().seatNo(seatNumber)
                        .seatType(SeatType.PREMIUM).theater(theater).build();

                //It is mandatory to add parent class entity in builder as foreign Key;

                //adding to the list
                theaterSeatsList.add(theaterSeats);

            }
        }
        //for the last row
        for(int j =1;j<=noOfSeatsInLastRowPremium;j++) {
            char ch = (char)('A'+j-1);
            String seatNumber = ""+row+ch;

            TheaterSeats theaterSeats = TheaterSeats.builder().seatNo(seatNumber)
                    .seatType(SeatType.PREMIUM).theater(theater).build();

            //It is mandatory to add parent class entity in builder as foreign Key;

            //adding to the list
            theaterSeatsList.add(theaterSeats);
        }
        //for Bidirectional Mapping we have created an arraylist in ParentClass to store the theaterSeats(child class ref)
        //and saved to parent class DB;
        theater.setTheaterSeatsList(theaterSeatsList);
        theaterRepository.save(theater);


        //Save all the generated Theater seats into the DB
        theaterSeatRepository.saveAll(theaterSeatsList);
        return "The theater seats have been associated";

    }
}
