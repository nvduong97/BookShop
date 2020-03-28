package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.entity.Publisher;
import com.example.demo.model.dto.AuthorDto;
import com.example.demo.model.dto.PublisherDto;
import com.example.demo.model.mapper.AuthorMapper;
import com.example.demo.model.mapper.PublisherMapper;
import com.example.demo.model.request.CreatePublisherReq;
import com.example.demo.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PublisherServiceImpl implements PublisherService{
    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public List<PublisherDto> getPublishers() {
        List<PublisherDto> result = new ArrayList<>();
        List<Publisher> publishers = publisherRepository.findAll();
        for (Publisher publisher: publishers) {
            result.add(PublisherMapper.toPublisherDto(publisher));
        }
        return result;
    }

    @Override
    public CreatePublisherReq createPublisher(CreatePublisherReq req) {
        Publisher publisher = new Publisher();
        publisher.setName(req.getName());
        publisher.setAddress(req.getAddress());
        publisher.setEmail(req.getEmail());
        publisherRepository.save(publisher);
        return req;
    }
}
