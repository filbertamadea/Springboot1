package com.example.belajarSpring.validators;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.belajarSpring.models.entitiy.Book;

@Service
public class BookValidator {
    public void validateBookNotFound(Optional<Book> bookFind) throws Exception {
        if (bookFind.isEmpty()) {
          throw new Exception("Book is not found!");
        }
      }
    public void validateBookListNotFound(Optional<List<Book>> bookFind) throws Exception {
        if (bookFind.isEmpty()) {
            throw new Exception("Book is not found!");
        }
    }
    
      public void validateIsAlreadyDeleted(Book book) throws Exception {
        if (book.isDeleted()) {
          throw new Exception("Book is already deleted!");
        }
      }
}
