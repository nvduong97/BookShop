package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="image")
    private String image;

    @Column(name="amount")
    private int amount;

    @Column(name="price")
    private int price;

    @Column(name="created_date")
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date createdDate;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="publisher_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Publisher publisher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Author author;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<CartDetail> cartDetails;

    @JsonIgnore
    public List<CartDetail> getCartDetails() {
        return cartDetails;
    }

    @JsonIgnore
    public void setCartDetails(List<CartDetail> cartDetails) {
        this.cartDetails = cartDetails;
    }

//    @JsonIgnore
//    public Author getAuthor() {
//        return author;
//    }
//
//    @JsonIgnore
//    public void setAuthor(Author author) {
//        this.author = author;
//    }

    @JsonIgnore
    public Publisher getPublisher() {
        return publisher;
    }

    @JsonIgnore
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
