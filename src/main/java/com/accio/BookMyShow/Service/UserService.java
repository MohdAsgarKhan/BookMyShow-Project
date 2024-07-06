package com.accio.BookMyShow.Service;

import com.accio.BookMyShow.Models.User;
import com.accio.BookMyShow.Repository.UserRepository;
import com.accio.BookMyShow.Requests.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(AddUserRequest addUserRequest) {

        User user = User.builder().userName(addUserRequest.getUserName())
                .age(addUserRequest.getAge())
                .emailId(addUserRequest.getEmailId())
                .mobNo(addUserRequest.getMobNo())
                .build();

        user = userRepository.save(user);

        return "The user has been added to the DB with userId " +user.getUserId();
    }
}
