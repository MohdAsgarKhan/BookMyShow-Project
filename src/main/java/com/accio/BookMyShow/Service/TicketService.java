package com.accio.BookMyShow.Service;

import com.accio.BookMyShow.Enum.SeatType;
import com.accio.BookMyShow.Models.ShowSeat;
import com.accio.BookMyShow.Models.Shows;
import com.accio.BookMyShow.Models.Ticket;
import com.accio.BookMyShow.Models.User;
import com.accio.BookMyShow.Repository.ShowRepository;
import com.accio.BookMyShow.Repository.ShowSeatRepository;
import com.accio.BookMyShow.Repository.TicketRepository;
import com.accio.BookMyShow.Repository.UserRepository;
import com.accio.BookMyShow.Requests.BookTicketRequest;
import com.accio.BookMyShow.Response.TicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public String bookTicket(BookTicketRequest bookTicketRequest) {

        //Step1: FInd the show Entity
        Shows shows = showRepository.findById(bookTicketRequest.getShowId()).get();

        //Step2: FInd the User Entity
        User user = userRepository.findById(bookTicketRequest.getUserID()).get();

        //Step3: Marked those seats as booked and calculate total amount

        int totalAmount = 0;
        List<ShowSeat> showSeatList = shows.getShowSeatList();
        for(ShowSeat showSeat: showSeatList ) {

            String seatNo = showSeat.getSeatNo();
            if(bookTicketRequest.getRequestedSeats().contains(seatNo)) {
                showSeat.setIsBooked(Boolean.TRUE);

                if(showSeat.getSeatType().equals(SeatType.CLASSIC)) {
                    totalAmount = totalAmount + 100;
                }
                else{
                    totalAmount = totalAmount + 150;
                }
            }
        }

        //Step$:Create the Ticket Entity and save the attributes (using builder)

        Ticket ticket = Ticket.builder().showDate(shows.getShowDate())
                .showTime(shows.getShowTime())
                .totalAmount(totalAmount)
                .movieName(shows.getMovie().getMovieName())
                .theaterName(shows.getTheater().getTheaterName())
                .bookedSeats(bookTicketRequest.getRequestedSeats().toString())
                .shows(shows)
                .user(user)
                .build();

        showSeatRepository.saveAll(showSeatList);

        ticket = ticketRepository.save(ticket);
        return ticket.getTicketId();
    }

    public TicketResponse generateTicket(String ticketId) {

        //Get the Ticket Entity
        Ticket ticket = ticketRepository.findById(ticketId).get();

        //Entity needs to be converted into Ticket Response

        TicketResponse ticketResponse = TicketResponse.builder()
                .bookedSeats(ticket.getBookedSeats())
                .movieName(ticket.getMovieName())
                .theaterName(ticket.getTheaterName())
                .showDate(ticket.getShowDate())
                .showTime(ticket.getShowTime())
                .totalAmount(ticket.getTotalAmount())
                .build();

        return ticketResponse;
    }
}
