package com.example.belajarSpring.repositories;

import com.example.belajarSpring.models.entitiy.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findBynamaKategori(String namaKategori);
}