package com.example.demo.controller;

import com.example.demo.model.dto.PublisherDto;
import com.example.demo.model.request.CreatePublisherReq;
import com.example.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/publishers")
@RestController
public class PublisherController {
    @Autowired
    PublisherService publisherService;

    @GetMapping("")
    public ResponseEntity<?> getPublishers() {
        List<PublisherDto> result = publisherService.getPublishers();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("")
    public ResponseEntity<?> createPublisher(@Valid @RequestBody CreatePublisherReq req) {
        CreatePublisherReq result = publisherService.createPublisher(req);
        return ResponseEntity.ok(result);
    }
}
