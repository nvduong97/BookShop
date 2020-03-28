package com.example.demo.service;

import com.example.demo.entity.CartDetail;
import com.example.demo.model.request.CreateCartDetailReq;
import com.example.demo.model.request.UpdateCartDetailReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartDetailService {
    void deleteCart(int id);

    CartDetail updateCartDetail(UpdateCartDetailReq req);

    CartDetail createCart(CreateCartDetailReq req);

    CartDetail getCartById(int id);

    CartDetail getCartByBookIdAndCartID(int bookId, int cartId);

    List<CartDetail> getCartDetails(int id);

    List<CartDetail> getCarts();
}
