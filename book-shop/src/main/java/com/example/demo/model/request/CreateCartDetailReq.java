package com.example.demo.model.request;

import com.example.demo.entity.Book;
import com.example.demo.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCartDetailReq {

    private int amount;
    private int totalMoney;
    private Cart cart;
    private int bookId;
}
