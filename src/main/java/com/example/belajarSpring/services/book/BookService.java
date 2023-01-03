package com.example.belajarSpring.services.book;

import com.example.belajarSpring.models.dto.request.BookRequest;
import com.example.belajarSpring.models.dto.response.BookResponse;

public interface BookService {

    BookResponse createBookService(BookRequest request) throws Exception;

    BookResponse readBookService();

    BookResponse readBookService(Long id) throws Exception;

    BookResponse readBookServiceByTitle(String judul) throws Exception;

    BookResponse updateBookService(Long id, BookRequest request) throws Exception;

    BookResponse deleteBookService(Long id) throws Exception;
    
}
