package com.example.belajarSpring.repositories;

import com.example.belajarSpring.models.entitiy.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.belajarSpring.models.entitiy.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<List<Book>> findByJudulContaining(String judul);
    Book findAllByJudul(String judul);
}
