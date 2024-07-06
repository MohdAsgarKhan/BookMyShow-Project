package com.accio.BookMyShow.Requests;

import lombok.Data;

@Data
public class AddUserRequest {

    private String userName;
    private Integer age;
    private String emailId;
    private String mobNo;
}
