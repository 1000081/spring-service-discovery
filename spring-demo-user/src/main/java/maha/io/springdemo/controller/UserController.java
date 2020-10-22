package maha.io.springdemo.controller;

import maha.io.springdemo.entity.User;
import maha.io.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity<>(":Successfully Created", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAlluser(){
        List<User> addresses = userService.getAllUser();
        if(!CollectionUtils.isEmpty(addresses)) {
            return new ResponseEntity<>(addresses, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long userId){
        Optional<User> addresses = userService.getUser(userId);
        if(addresses.isPresent()) {
            return new ResponseEntity<>(addresses.get(), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}
