package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.Cart;
import com.example.demo.entity.CartDetail;
import com.example.demo.entity.User;
import com.example.demo.model.dto.BookDto;
import com.example.demo.model.dto.ResponseResult;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.model.request.*;
import com.example.demo.security.CustomUserDetails;
import com.example.demo.service.BookService;
import com.example.demo.service.CartDetailService;
import com.example.demo.service.CartService;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api")
@RestController
public class CartController {

    @Autowired
    public CartService cartService;

    @Autowired
    public CartDetailService cartDetailService;

    @Autowired
    public BookService bookService;


    @Autowired
    public UserService userService;

    @GetMapping("/carts")
    public ResponseEntity<?> getCarts() {
        List<Cart> result = cartService.getCarts();

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/carts/{id}")
    public ResponseEntity<?> getCartById(@PathVariable int id) {
        Cart result = cartService.getCartById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/carts")
    public ResponseResult createCart(@Valid @RequestBody CreateCartReq req) {
        ResponseResult result = new ResponseResult();
        try {
            CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userDetails.getUser();
            Cart cart = cartService.findCartByUser(user.getId());
            if (cart == null) {
                req.setUser(user);
                cart = cartService.createCart(req);
                CreateCartDetailReq createCartReq = new CreateCartDetailReq(req.getAmount(), 0, cart, req.getBookId());
                cartDetailService.createCartDetail(createCartReq);
            } else {
                CartDetail cartDetail = cartDetailService.findDetailCartByBookIdAndCartId(req.getBookId(), cart.getId());
                if (cartDetail != null) {
                    int amount = cartDetail.getAmount() + req.getAmount();
                    cartDetailService.updateCartDetail(new UpdateCartDetailReq(amount, cartDetail.getId()));
                } else {
                    CreateCartDetailReq createCartReq = new CreateCartDetailReq(req.getAmount(), 0, cart, req.getBookId());
                    cartDetailService.createCartDetail(createCartReq);
                }
            }
            cart = cartService.updateCart(cart.getId());
            result.setMessage("Đã thêm vào giỏ hàng!");
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMessage("Bạn cần đăng nhập!");
            result.setSuccess(false);
        }
        return result;
    }

    @PutMapping("/carts/{id}")
    public ResponseEntity<?> updateCart(@PathVariable int id) {
        Cart result = cartService.updateCart(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/carts/{id}")
    public ResponseEntity<?> deleteCart(@PathVariable int id) {
        cartService.deleteCart(id);
        return ResponseEntity.ok("Xóa thành công");
    }

    @PostMapping("/checkout")
    public ResponseResult checkOut(@Valid @RequestBody UserDto req) {
        ResponseResult result = new ResponseResult();
        try {
            userService.updateUser(req);
            cartService.updateCartStatus(req.getId());
            result.setMessage("Đơn hàng đã được tạo!");
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("Đã xảy ra lỗi!");
            result.setSuccess(false);
        }
        return result;
    }
}
