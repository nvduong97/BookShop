package com.example.demo.controller;

import com.example.demo.model.dto.AuthorDto;
import com.example.demo.model.request.CreateAuthorReq;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/authors")
@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping("")
    public ResponseEntity<?> getAuthors() {
        List<AuthorDto> result = authorService.getAuthors();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("")
    public ResponseEntity<?> createAuthor(@Valid @RequestBody CreateAuthorReq req) {
        CreateAuthorReq result = authorService.createAuthor(req);
        return ResponseEntity.ok(result);
    }
}
