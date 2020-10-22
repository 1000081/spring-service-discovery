package maha.io.springdemo.controller;

import maha.io.springdemo.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping(path = "/users-details")
public class UserDetailsController {

    @Autowired
    private UserDetailsService userService;

    @GetMapping
    public ResponseEntity<Map<String, String>> getAlluser(){
        return userService.getUserDetails();
    }
}
