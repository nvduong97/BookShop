package com.example.demo.service;

import com.example.demo.model.dto.PublisherDto;
import com.example.demo.model.request.CreatePublisherReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublisherService {
    public List<PublisherDto> getPublishers();

    public CreatePublisherReq createPublisher(CreatePublisherReq req);
}
