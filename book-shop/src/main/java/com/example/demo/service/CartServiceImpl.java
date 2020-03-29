package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Cart;
import com.example.demo.entity.CartDetail;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.request.CreateCartReq;
import com.example.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    BookService bookService;

    @Autowired
    CartDetailService cartDetailService;


    @Override
    public Cart findCartByUser(int userId) {
        Cart cart = cartRepository.findByUserName(userId);
        return cart;
    }

    @Override
    public Page<Cart> getCartPage(Pageable pageable) {
        Page<Cart> carts = cartRepository.findAll(pageable);
        return carts;
    }

    @Override
    public Page<Cart> getOrders(Pageable pageable) {
        Page<Cart> carts = cartRepository.findOrders(pageable);
        return carts;
    }

    @Override
    public Page<Cart> getOrdersByUser(Pageable pageable, int id) {
        Page<Cart> carts = cartRepository.findOrdersByUser(pageable, id);
        return carts;
    }

    @Override
    public List<Cart> getCarts() {
        List<Cart> carts = cartRepository.findAll();
        return carts;
    }

    @Override
    public Cart updateCart(int id) {
        List<CartDetail> list = cartDetailService.findCartDetailsByCartId(id);
        int money = 0;
        for (CartDetail cartDetail: list) {
            money += cartDetail.getTotalMoney();
        }

        Cart result = cartRepository.findById(id).get();
        if(result.equals(null)){
            throw new NotFoundException("Cart Not found");
        }
        result.setTotalMoney(money);
        cartRepository.save(result);
        return result;
    }

    @Override
    public void deleteCart(int id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Cart createCart(CreateCartReq req) {
        Book book = bookService.getBook(req.getBookId());
        int money = book.getPrice()*req.getAmount();

        Cart cart = new Cart();
        cart.setUser(req.getUser());
        cart.setCreatedDate(new Date());
        cart.setStatus(false);
        cart.setTotalMoney(money);

        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart getCartById(int id) {
        Optional<Cart> cart = cartRepository.findById(id);
        if(cart.equals(null)){
            throw new NotFoundException("Giỏ hàng không tồn tại");
        }
        return cart.get();
    }

    @Override
    public Boolean updateCartStatus(int id) {
        Cart cart = cartRepository.findByUserName(id);
        cart.setStatus(true);
        cartRepository.save(cart);
        return true;
    }
}
