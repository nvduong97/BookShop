package com.example.demo.model.dto;

import com.example.demo.entity.Author;
import com.example.demo.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private int id;
    private String name;
    private String image;
    private int amount;
    private int price;
    private Date createdDate;
    private int publisherId;
    private int authorId;
}
