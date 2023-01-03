package com.example.belajarSpring.validators;

import com.example.belajarSpring.models.entitiy.User;
import org.springframework.stereotype.Service;

import java.util.NavigableMap;
import java.util.Optional;

@Service
public class UserValidator {
    private User user;
    public void validateUserNotFound(Optional<User> userFind) throws Exception {
        if (userFind.isEmpty()) {
            throw new Exception("Book is not found!");
        }
    }
    public void validateUserName(String email) throws Exception {
        if(user.getEmail().equals(email)) {
            throw new Exception("e-mail sudah ada");
        }
    }
    public void validateIsAlreadyDeleted(User user) throws Exception {
        if (user.getDeleted()) {
            throw new Exception("Book is already deleted!");
        }
    }
}
