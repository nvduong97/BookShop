package com.example.demo.model.request;

import com.example.demo.entity.CartDetail;
import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCartReq {

    private int bookId;

    private int amount;

    private String userName;

    private User user;

    private CreateCartDetailReq cartDetails;
}
