package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.model.dto.AuthorDto;
import com.example.demo.model.mapper.AuthorMapper;
import com.example.demo.model.request.CreateAuthorReq;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<AuthorDto> getAuthors() {
        List<AuthorDto> result = new ArrayList<>();
        List<Author> authors = authorRepository.findAll();
        for (Author author: authors) {
            result.add(AuthorMapper.toAuthorDto(author));
        }
        return result;
    }

    @Override
    public CreateAuthorReq createAuthor(CreateAuthorReq req) {
        Author author = new Author();
        author.setName(req.getName());
        author.setAddress(req.getAddress());
        author.setEmail(req.getEmail());
        authorRepository.save(author);
        return req;
    }
}
