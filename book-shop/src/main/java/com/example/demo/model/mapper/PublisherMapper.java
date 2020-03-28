package com.example.demo.model.mapper;

import com.example.demo.entity.Publisher;
import com.example.demo.model.dto.PublisherDto;

public class PublisherMapper {
    public static PublisherDto toPublisherDto(Publisher publisher) {
        PublisherDto publisherDto = new PublisherDto();
        publisherDto.setId(publisher.getId());
        publisherDto.setName(publisher.getName());
        publisherDto.setBooks(publisher.getBooks());
        return publisherDto;
    }
}
