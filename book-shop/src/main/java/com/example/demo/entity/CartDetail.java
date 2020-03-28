package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cart_detail")
public class CartDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(name = "amount")
    private int amount;

    @NotNull
    @Column(name = "total_money")
    private int totalMoney;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @JsonIgnore
    public Cart getCart() {
        return cart;
    }

    @JsonIgnore
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @JsonIgnore
    public Book getBook() {
        return book;
    }

    @JsonIgnore
    public void setBook(Book book) {
        this.book = book;
    }
}
