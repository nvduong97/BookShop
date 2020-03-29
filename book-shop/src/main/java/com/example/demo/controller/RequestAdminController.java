package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.Cart;
import com.example.demo.model.dto.AuthorDto;
import com.example.demo.model.dto.PublisherDto;
import com.example.demo.model.mapper.BookMapper;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.model.dto.BookDto;
import com.example.demo.service.CartService;
import com.example.demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RequestAdminController {
    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;
    @Autowired
    PublisherService publisherService;
    @Autowired
    CartService cartService;

    @GetMapping("/admin")
    public String getBookByName(Model model,
                                @RequestParam(required = false, defaultValue = "") String keyword,
                                @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                @RequestParam(name = "size", required = false, defaultValue = "10") Integer size) {
        List<BookDto> result = new ArrayList<>();
        Page<Book> books = bookService.getBooksByName(keyword.trim(), PageRequest.of(page, size));
        for (Book book: books.getContent()) {
            result.add(BookMapper.toBookDto(book));
        }
        model.addAttribute("authorDtos", authorService.getAuthors());
        model.addAttribute("publisherDtos", publisherService.getPublishers());
        model.addAttribute("page", books);
        model.addAttribute("books", result);
        return "/admin/index";
    }


    @GetMapping("/admin/orderDetail")
    public String orderDetail(Model model, @RequestParam(required = false) Integer id) {
        Cart cart = cartService.getCartById(id);
        model.addAttribute("cart", cart);
        return "/admin/orderDetail";
    }

    @GetMapping("/admin/order")
    public String order(Model model,
                        @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                        @RequestParam(name = "size", required = false, defaultValue = "10") Integer size) {
        Page<Cart> carts = cartService.getOrders(PageRequest.of(page, size));
        model.addAttribute("page", carts);
        model.addAttribute("carts", carts.getContent());
        return "/admin/order";
    }


    @GetMapping("/admin/error")
    public String delete(){
        return "/admin/blank_page";
    }

    @GetMapping("/admin/login")
    public String signIn() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            return "/admin/sign-in";
        }
        return "index";
    }

    @GetMapping("/admin/register")
    public String signUp() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            return "/admin/sign-up";
        }
        return "index";
    }
}

