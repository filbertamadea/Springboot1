package com.example.belajarSpring.controllers;

import com.example.belajarSpring.models.dto.request.UserRequest;
import com.example.belajarSpring.models.dto.response.BookResponse;
import com.example.belajarSpring.models.dto.response.UserResponse;
import com.example.belajarSpring.models.entitiy.User;
import com.example.belajarSpring.repositories.UserRepository;
import com.example.belajarSpring.services.user.UserServices;
import com.example.belajarSpring.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class userController {
    @Autowired
    private UserServices userServices;

    @Autowired
    private UserValidator userValidator;
    private UserResponse userResponse;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserRequest request){
        try {
            userResponse = userServices.createUser(request);
            return ResponseEntity.status(userResponse.getStatus()).body(userResponse);
        } catch (Exception e) {
            e.printStackTrace();
            userResponse = new UserResponse(500, e.getLocalizedMessage(), null);
            return ResponseEntity.status(userResponse.getStatus()).body(userResponse);
        }
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        try {
            userResponse = userServices.readUser();
            return ResponseEntity.ok().body(userResponse);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            userResponse = new UserResponse(500, e.getMessage(), null);
            return ResponseEntity.status(userResponse.getStatus()).body(userResponse);
        }
    }
}
