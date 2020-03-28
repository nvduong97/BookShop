package com.example.demo.model.dto;

import com.example.demo.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublisherDto {
    private int id;

    private String name;

    private List<Book> books;
}
