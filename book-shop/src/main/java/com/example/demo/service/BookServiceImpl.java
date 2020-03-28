package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.Publisher;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.BookDto;
import com.example.demo.model.mapper.BookMapper;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.model.request.CreateBookReq;
import com.example.demo.model.request.UpdateBookReq;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Page<Book> getListBook(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public List<BookDto> getListBook() {
        List<BookDto> result = new ArrayList<>();
        List<Book> books = bookRepository.findAll();
        for (Book book: books) {
            result.add(BookMapper.toBookDto(book));
        }
        return result;
    }

    @Override
    public List<BookDto> getNewBooks() {
        List<BookDto> result = new ArrayList<>();
        List<Book> books = bookRepository.getNewBooks();
        for (Book book: books) {
            result.add(BookMapper.toBookDto(book));
        }
        return result;
    }

    @Override
    public BookDto getBookById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        return BookMapper.toBookDto(book.get());
    }

    @Override
    public Book getBook(int id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.equals(null)){
            throw new NotFoundException("User Not found");
        }
        return book.get();
    }

    @Override
    public BookDto createBook(CreateBookReq req) {
        Book book = new Book();
        Optional<Author> author = authorRepository.findById(Integer.parseInt(req.getAuthorId()));
        Optional<Publisher> publisher = publisherRepository.findById(Integer.parseInt(req.getPublisherId()));

        book = BookMapper.toBook(req);
        book.setAuthor(author.get());
        book.setPublisher(publisher.get());
        bookRepository.save(book);
        return BookMapper.toBookDto(book);
    }

    @Override
    public BookDto updateBook(UpdateBookReq req, int id) {
        Book result = bookRepository.findById(id).get();
        if(result.equals(null)){
            throw new NotFoundException("Book Not found");
        }
        Optional<Author> author = authorRepository.findById(Integer.parseInt(req.getAuthorId()));
        Optional<Publisher> publisher = publisherRepository.findById(Integer.parseInt(req.getPublisherId()));

        result.setName(req.getName());
        result.setAmount(req.getAmount());
        result.setAuthor(author.get());
        result.setImage(req.getImage());
        result.setPrice(req.getPrice());
        result.setPublisher(publisher.get());
        bookRepository.save(result);
        return BookMapper.toBookDto(result);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<Book> getBooksByName(String keyword, Pageable pageable) {
//        return bookRepository.findByNameLike(pageable, keyword);
        return bookRepository.getBooksByKeyword(pageable, keyword);
    }
}
