package com.example.demo.model.request;

import com.example.demo.entity.Author;
import com.example.demo.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateBookReq {
    private String name;
    private String image;
    private int amount;
    private int price;
    private String publisherId;
    private String authorId;
}
