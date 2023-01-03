package com.example.belajarSpring.repositories;

import com.example.belajarSpring.models.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    Category findBynamaKategori(String namaKategori);

    User findAllByEmail(String email);
}
