package com.accio.BookMyShow.Controller;

import com.accio.BookMyShow.Models.Ticket;
import com.accio.BookMyShow.Requests.BookTicketRequest;
import com.accio.BookMyShow.Response.TicketResponse;
import com.accio.BookMyShow.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")

public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("bookTicket")

    private String bookTicket(@RequestBody BookTicketRequest bookTicketRequest) {

        return ticketService.bookTicket(bookTicketRequest);
    }

    @GetMapping("generateTicket")
    public TicketResponse generateTicket(@RequestParam("ticketId") String ticketId) {

        return ticketService.generateTicket(ticketId);
    }
}
