package com.accio.BookMyShow.Requests;

import lombok.Data;

@Data
public class AddTheaterSeatRequest {

    private Integer theaterSeatId;
    private Integer noOfClassicSeats;
    private Integer noOfPremiumSeats;


}
