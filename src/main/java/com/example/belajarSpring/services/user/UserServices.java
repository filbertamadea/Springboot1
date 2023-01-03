package com.example.belajarSpring.services.user;

import com.example.belajarSpring.models.dto.request.UserRequest;
import com.example.belajarSpring.models.dto.response.UserResponse;

public interface UserServices {

    UserResponse createUser(UserRequest request) throws Exception;
    UserResponse readUser();
    UserResponse updateUser(Long id, UserRequest request) throws Exception;
    UserResponse deleteUser(Long id) throws Exception;
}
