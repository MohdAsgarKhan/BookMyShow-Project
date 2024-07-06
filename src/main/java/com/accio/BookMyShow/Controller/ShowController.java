package com.accio.BookMyShow.Controller;

import com.accio.BookMyShow.Requests.AddShowRequest;
import com.accio.BookMyShow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shows")
public class ShowController {
    @Autowired
    private ShowService showService;
    @PostMapping("add")
    public ResponseEntity addShows(@RequestBody AddShowRequest addShowRequest) {

        String response = showService.addShows(addShowRequest);
        return new ResponseEntity(response, HttpStatus.OK);

    }
}
