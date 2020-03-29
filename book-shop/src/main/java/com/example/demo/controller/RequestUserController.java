package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.Cart;
import com.example.demo.entity.User;
import com.example.demo.model.dto.BookDto;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.BookMapper;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.security.CustomUserDetails;
import com.example.demo.service.BookService;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RequestUserController {
    @Autowired
    BookService bookService;

    @Autowired
    CartService cartService;

    @GetMapping("/")
    public String homePage(Model model,
                           @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                           @RequestParam(name = "size", required = false, defaultValue = "16") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> result = bookService.getListBook(pageable);
        isUser(model);
        model.addAttribute("newBooks", bookService.getNewBooks());
        model.addAttribute("page", result);
        model.addAttribute("books", result.getContent());
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model,
                           @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                           @RequestParam(name = "size", required = false, defaultValue = "20") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> result = bookService.getListBook(pageable);
        isUser(model);
        model.addAttribute("page", result);
        model.addAttribute("books", result.getContent());
        return "shop";
    }

    @GetMapping("/book/{id}")
    public String getBookByName(@PathVariable Integer id, Model model) {
        model.addAttribute("newBooks", bookService.getNewBooks());
        model.addAttribute("book" , bookService.getBookById(id));
        isUser(model);
        return "product-single";
    }

    @GetMapping("/cart")
    public String cart(Model model){
        Cart cart = new Cart();
        User user = null;
        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            user = userDetails.getUser();
            cart = cartService.findCartByUser(user.getId());
            if(cart == null)
                cart = new Cart();
        }
        model.addAttribute("user", user);
        model.addAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model){
        User user = null;
        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            user = userDetails.getUser();
        }
        model.addAttribute("user", user);
        return "checkout";
    }

    @GetMapping("/account")
    public String account(Model model,
                          @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                          @RequestParam(name = "size", required = false, defaultValue = "10") Integer size){
        User user = null;
        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            user = userDetails.getUser();

            Page<Cart> carts = cartService.getOrdersByUser(PageRequest.of(page, size), user.getId());
            model.addAttribute("page", carts);
            model.addAttribute("carts", carts.getContent());
        }
        model.addAttribute("user", user);
        return "account";
    }

    @GetMapping("/orderDetail")
    public String orderDetail(Model model, @RequestParam(required = false) Integer id) {
        Cart cart = cartService.getCartById(id);
        isUser(model);
        model.addAttribute("cart", cart);
        return "orderDetail";
    }

    @GetMapping("/search")
    public String search(Model model,
                                @RequestParam(required = false, defaultValue = "") String keyword,
                                @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                @RequestParam(name = "size", required = false, defaultValue = "20") Integer size) {
        List<BookDto> result = new ArrayList<>();
        Page<Book> books = bookService.getBooksByName(keyword.trim(), PageRequest.of(page, size));
        for (Book book: books.getContent()) {
            result.add(BookMapper.toBookDto(book));
        }
        isUser(model);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", books);
        model.addAttribute("books", result);
        return "products";
    }

    @GetMapping("/403")
    public String error(){
        return "admin/blank_page";
    }

    private void isUser(Model model) {
        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserDto userDto = UserMapper.toUserDto(user.getUser());
            model.addAttribute("user", userDto);
        }
    }
}
