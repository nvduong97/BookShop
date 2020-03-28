package com.example.demo.model.mapper;

import com.example.demo.entity.Author;
import com.example.demo.model.dto.AuthorDto;

public class AuthorMapper {
    public static AuthorDto toAuthorDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setBooks(author.getBooks());
        return authorDto;
    }
}
