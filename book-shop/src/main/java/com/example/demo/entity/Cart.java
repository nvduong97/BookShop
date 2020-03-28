package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cart")
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "status")
    private boolean status;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "total_money")
    private int totalMoney;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "cart")
    private List<CartDetail> cartDetails;

//    @JsonIgnore
//    public List<CartDetail> getCartDetails() {
//        return cartDetails;
//    }
//
//    @JsonIgnore
//    public void setCartDetails(List<CartDetail> cartDetails) {
//        this.cartDetails = cartDetails;
//    }
}
