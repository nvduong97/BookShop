package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.CartDetail;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.request.CreateCartDetailReq;
import com.example.demo.model.request.UpdateCartDetailReq;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CartDetailServiceImpl implements CartDetailService {
    @Autowired
    public CartDetailRepository cartDetailRepository;

    @Autowired
    public BookService bookService;


    @Override
    public void deleteCart(int id) {
        cartDetailRepository.deleteById(id);
    }

    @Override
    public CartDetail updateCartDetail(UpdateCartDetailReq req) {
        CartDetail result = cartDetailRepository.findById(req.getId()).get();
        if(result.equals(null)){
            throw new NotFoundException("Cart Not found");
        }
        int money = req.getAmount()*result.getBook().getPrice();
        result.setAmount(req.getAmount());
        result.setTotalMoney(money);
        cartDetailRepository.save(result);
        return result;
    }

    @Override
    public CartDetail createCartDetail(CreateCartDetailReq req) {
        Book book = bookService.getBook(req.getBookId());
        int totalMoney = book.getPrice()*req.getAmount();

        CartDetail cart = new CartDetail();
        cart.setTotalMoney(totalMoney);
        cart.setAmount(req.getAmount());
        cart.setBook(book);
        cart.setCart(req.getCart());

        cartDetailRepository.save(cart);
        return cart;
    }

    @Override
    public CartDetail findCartDetailById(int id) {
        Optional<CartDetail> cart = cartDetailRepository.findById(id);
        if(cart.equals(null)){
            throw new NotFoundException("Cart Not found");
        }
        return cart.get();
    }

    @Override
    public CartDetail findDetailCartByBookIdAndCartId(int bookId, int cartId) {
        CartDetail cartDetail = cartDetailRepository.findCartByBookIdAndCartID(bookId,cartId);
        return cartDetail;
    }

    @Override
    public List<CartDetail> findCartDetailsByCartId(int id) {
        List<CartDetail> carts = cartDetailRepository.findByCartId(id);
        return carts;
    }

    @Override
    public List<CartDetail> getCartDetails() {
        List<CartDetail> carts = cartDetailRepository.findAll();
        return carts;
    }
}
