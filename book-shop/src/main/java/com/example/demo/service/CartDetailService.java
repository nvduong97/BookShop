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

    CartDetail createCartDetail(CreateCartDetailReq req);

    CartDetail findCartDetailById(int id);

    CartDetail findDetailCartByBookIdAndCartId(int bookId, int cartId);

    List<CartDetail> findCartDetailsByCartId(int id);

    List<CartDetail> getCartDetails();
}
