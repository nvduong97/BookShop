package com.example.demo.controller;

import com.example.demo.entity.Cart;
import com.example.demo.entity.CartDetail;
import com.example.demo.model.dto.ResponseResult;
import com.example.demo.model.request.CreateCartDetailReq;
import com.example.demo.model.request.UpdateCartDetailReq;
import com.example.demo.service.CartDetailService;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/cartDetail")
@RestController
public class CartDetailController {
    @Autowired
    public CartDetailService cartDetailService;
    @Autowired
    public CartService cartService;

    @GetMapping("")
    public ResponseEntity<?> getCarts() {
        List<CartDetail> result = cartDetailService.getCarts();

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCartById(@PathVariable int id) {
        CartDetail result = cartDetailService.getCartById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<?> createCart(@Valid @RequestBody CreateCartDetailReq req) {
        CartDetail result = cartDetailService.createCart(req);
        return ResponseEntity.ok(result);
    }

    @PutMapping("")
    public ResponseResult updateCart(@Valid @RequestBody UpdateCartDetailReq req) {
        ResponseResult result = new ResponseResult();
        try {
            CartDetail cartDetail = cartDetailService.updateCartDetail(req);
            Cart cart = cartService.updateCart(cartDetail.getCart().getId());
            result.setMessage("Cập nhật thành công");
            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("Đã xảy ra lỗi");
            result.setSuccess(false);
        }
        return result;
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteCart(@PathVariable int id) {
        ResponseResult result = new ResponseResult();
        try {
            int cartId = cartDetailService.getCartById(id).getCart().getId();
            cartDetailService.deleteCart(id);
            cartService.updateCart(cartId);
            result.setMessage("Cập nhật thành công");
            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("Đã xảy ra lỗi");
            result.setSuccess(false);
        }
        return result;
    }
}
