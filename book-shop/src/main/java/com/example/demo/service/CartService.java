package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Cart;
import com.example.demo.model.request.CreateCartReq;
import com.example.demo.model.request.UpdateCartReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CartService {

    Cart findCartByUser(int userId);

    public Page<Cart> getCartPage(Pageable pageable);

    public Page<Cart> getOrders(Pageable pageable);

    public Page<Cart> getOrdersByUser(Pageable pageable, int userId);

    List<Cart> getCarts();

    Cart updateCart(int id);

    void deleteCart(int id);

    Cart createCart(CreateCartReq req);

    Cart getCartById(int id);

    Boolean updateCartStatus(int id);
}
