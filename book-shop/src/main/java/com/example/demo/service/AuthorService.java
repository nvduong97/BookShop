package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.model.dto.AuthorDto;
import com.example.demo.model.request.CreateAuthorReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

    public List<AuthorDto> getAuthors();

    public CreateAuthorReq createAuthor(CreateAuthorReq req);
}
