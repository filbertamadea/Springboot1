package com.example.belajarSpring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.belajarSpring.models.dto.request.BookRequest;
import com.example.belajarSpring.models.dto.response.BookResponse;
import com.example.belajarSpring.models.entitiy.Book;
import com.example.belajarSpring.repositories.BookRepository;
import com.example.belajarSpring.services.book.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    private BookResponse bookResponse;

    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody BookRequest request) {
        try {
            bookResponse = bookService.createBookService(request);
            return ResponseEntity.status(bookResponse.getStatus()).body(bookResponse);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            bookResponse = new BookResponse(500, e.getMessage(), null);
            return ResponseEntity.status(bookResponse.getStatus()).body(bookResponse);
        }
    }

    @GetMapping
    public ResponseEntity<?> getBooks() {
        try {
            bookResponse = bookService.readBookService();
            return ResponseEntity.ok().body(bookResponse);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            bookResponse = new BookResponse(500, e.getMessage(), null);
            return ResponseEntity.status(bookResponse.getStatus()).body(bookResponse);
        }
    }

    @GetMapping("/{idBook}")
    public ResponseEntity<?> getBookById(@PathVariable("idBook") Long id) {
        try {
            bookResponse = bookService.readBookService(id);
            return ResponseEntity.ok().body(bookResponse);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            bookResponse = new BookResponse(500, e.getMessage(), null);
            return ResponseEntity.status(bookResponse.getStatus()).body(bookResponse);
        }
    }

    @GetMapping("/judul")
    public ResponseEntity<?> getBookByTitle(@RequestParam String judul) {
        try {
            bookResponse = bookService.readBookServiceByTitle(judul);
            return ResponseEntity.ok().body(bookResponse);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            bookResponse = new BookResponse(500, e.getMessage(), null);
            return ResponseEntity.status(bookResponse.getStatus()).body(bookResponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBookById(@PathVariable Long id, @RequestBody BookRequest request) {
        try {
            bookResponse = bookService.updateBookService(id, request);
            return ResponseEntity.status(bookResponse.getStatus()).body(bookResponse);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            bookResponse = new BookResponse(500, e.getMessage(), null);
            return ResponseEntity.status(bookResponse.getStatus()).body(bookResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        try {
            bookResponse = bookService.deleteBookService(id);
            return ResponseEntity.ok().body(bookResponse);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            bookResponse = new BookResponse(500, e.getMessage(), null);
            return ResponseEntity.status(bookResponse.getStatus()).body(bookResponse);
        }
    }
}
