package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "role", nullable = false, columnDefinition = "varchar(255) default 'USER'")
    private String role;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private Date birthdate;

    @Column(name = "address")
    private String address;

    @Column(name = "phone", length = 11)
    private String phone;

    @OneToMany(mappedBy="user")
    private List<Cart> carts;

    @JsonIgnore
    public List<Cart> getCarts() {
        return carts;
    }

    @JsonIgnore
    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}
