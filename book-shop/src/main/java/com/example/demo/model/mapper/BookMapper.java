package com.example.demo.model.mapper;

import com.example.demo.entity.Book;
import com.example.demo.model.dto.BookDto;
import com.example.demo.model.request.CreateBookReq;

import java.util.Date;

public class BookMapper {
    public static BookDto toBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setAmount(book.getAmount());
        bookDto.setAuthorId(book.getAuthor().getId());
        bookDto.setImage(book.getImage());
        bookDto.setPrice(book.getPrice());
        bookDto.setCreatedDate(book.getCreatedDate());
        bookDto.setPublisherId(book.getPublisher().getId());
        return bookDto;
    }

    public static Book toBook(CreateBookReq req) {
        Book book = new Book();
        book.setName(req.getName());
        book.setAmount(req.getAmount());
        book.setImage(req.getImage());
        book.setPrice(req.getPrice());
        book.setCreatedDate(new Date());
        return  book;
    }
}
