package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.model.dto.BookDto;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateBookReq;
import com.example.demo.model.request.UpdateBookReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    public Page<Book>  getListBook(Pageable pageable);

    public  List<BookDto> getListBook();

    public List<BookDto> getNewBooks();

    public BookDto getBookById(int id);

    public Book getBook(int id);

    public BookDto createBook(CreateBookReq req);

    public BookDto updateBook(UpdateBookReq req, int id);

    public void deleteBook(int id);

    public Page<Book> getBooksByName(String keyword, Pageable pageable);
}
