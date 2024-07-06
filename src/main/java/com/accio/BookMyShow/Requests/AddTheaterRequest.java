package com.accio.BookMyShow.Requests;

import lombok.Data;

@Data
public class AddTheaterRequest {

    private String theaterName;
    private Integer noOfScreens;
    private String address;
}
