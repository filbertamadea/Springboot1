package com.example.belajarSpring.services.user;


import com.example.belajarSpring.models.dto.request.UserRequest;
import com.example.belajarSpring.models.dto.response.BookResponse;
import com.example.belajarSpring.models.dto.response.UserResponse;
import com.example.belajarSpring.models.entitiy.Book;
import com.example.belajarSpring.models.entitiy.User;
import com.example.belajarSpring.repositories.UserRepository;
import com.example.belajarSpring.validators.UserValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserValidator userValidator;

    private User user;
    private List<User> users;
    private UserResponse userResponse;

    @Override
    public UserResponse createUser(UserRequest request) {
        if (request.getNama() == null || request.getEmail() == null || request.getPassword() == null || request.getNotelp() == null ){
            userResponse = new UserResponse(400, "Request tidak bisa dilakukan", null);
        } else {
            user = new User();
            user.setNama(request.getNama());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setNotelp(request.getNotelp());

            userRepository.save(user);

            userResponse = new UserResponse(HttpStatus.CREATED.value(), "Sukses Menambahkan User", user);
        }
        return userResponse;
    }

    @Override
    public UserResponse readUser() {
        users = userRepository.findAll();
        userResponse = new UserResponse(200, "Sukses ditemukan", users);
        return userResponse;
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) throws Exception {
        return null;
    }

    @Override
    public UserResponse deleteUser(Long id) throws Exception {
        return null;
    }
}
