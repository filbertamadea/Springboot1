package com.example.belajarSpring.services.book;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.belajarSpring.exceptions.custom.CustomNotFoundException;
import com.example.belajarSpring.models.entitiy.Category;
import com.example.belajarSpring.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.belajarSpring.models.dto.request.BookRequest;
import com.example.belajarSpring.models.dto.response.BookResponse;
import com.example.belajarSpring.models.entitiy.Book;
import com.example.belajarSpring.repositories.BookRepository;
import com.example.belajarSpring.validators.BookValidator;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookValidator bookValidator;

    private Book book;
    private BookResponse bookResponse;
    private List<Book> books;
    private Optional<List<Book>> bookList;
    @Override
    public BookResponse createBookService(BookRequest request) throws Exception {
        // TODO Auto-generated method stub
        if (request.getJudul() == null || request.getPenerbit() == null || request.getPenulis() == null
                || request.getStok() == 0) {
            bookResponse = new BookResponse(400, "Bad Request.", null);
        } else {


            // Instance book
            book = new Book();

            // Convert DTO to Entity
            book.setPenerbit(request.getPenerbit());
            book.setPenulis(request.getPenulis());
            book.setStokBuku(request.getStok());

            Book findBook = bookRepository.findAllByJudul(request.getJudul());
            if(Objects.isNull(findBook) == false){
                throw new CustomNotFoundException("Judul sudah ada");
            }
            book.setJudul(request.getJudul());

            Category category = categoryRepository.findBynamaKategori(request.getNamaKategori());
            if (Objects.isNull(category)) {
                throw new CustomNotFoundException("Category not exist");
            }
            book.setCategory(category);


            // Save to repo
            bookRepository.save(book);

            // Response Data
            bookResponse = new BookResponse(HttpStatus.CREATED.value(), "success", book);
        }

        return bookResponse;
    }

    @Override
    public BookResponse readBookService() {
        // TODO Auto-generated method stub
        books = bookRepository.findAll();
        bookResponse = new BookResponse(200, "Sukses ditemukan", books);
        return bookResponse;
    }

    @Override
    public BookResponse readBookService(Long id) throws Exception {
        // TODO Auto-generated method stub
        Optional<Book> bookFind = bookRepository.findById(id);
        book = bookFind.get();
        bookResponse = new BookResponse(200, "Sukses ditemukan", book);
        return bookResponse;
    }

    @Override
    public BookResponse updateBookService(Long id, BookRequest request) throws Exception {
        // TODO Auto-generated method stub
        Optional<Book> bookFind = bookRepository.findById(id);

        book = bookFind.get();
        book.setJudul(request.getJudul());
        book.setPenulis(request.getPenulis());
        book.setPenerbit(request.getPenulis());
        book.setStokBuku(request.getStok());

        bookRepository.save(book);
        bookResponse = new BookResponse(200, "success updated", book);
        return bookResponse;
    }

    @Override
    public BookResponse deleteBookService(Long id) throws Exception {
        // TODO Auto-generated method stub
        Optional<Book> bookFind = bookRepository.findById(id);
        bookValidator.validateBookNotFound(bookFind);

        book = bookFind.get();
        bookValidator.validateIsAlreadyDeleted(book);

        book.setDeleted(true);
        bookRepository.save(book);
        return bookResponse;
    }

    @Override
    public BookResponse readBookServiceByTitle(String judul) throws Exception{
        // TODO Auto-generated method stub
        Optional<List<Book>> bookList = bookRepository.findByJudulContaining(judul);
        bookValidator.validateBookListNotFound(bookList);

        List<Book> listBook = bookList.get();

        bookResponse = new BookResponse(200, "Sukses ditemukan", listBook);
        return bookResponse;
    }

}
