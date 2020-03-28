package com.example.demo.repository;

import com.example.demo.entity.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    //"SELECT * from `cart` WHERE user_id = 11 AND status = 0"

    @Query(value = "SELECT * from cart c " +
            "WHERE c.user_id = :userId " +
            "AND status = 0",nativeQuery = true)
    Cart findByUserName(@Param("userId") int userId);

    @Query(value = "SELECT * from cart c WHERE status = 1 ORDER BY created_date DESC",nativeQuery = true)
    Page<Cart> findOrders(Pageable pageable);

    @Query(value = "SELECT * from cart c " +
            "WHERE c.user_id = :userId " +
            "AND status = 1 ORDER BY created_date DESC",nativeQuery = true)
    Page<Cart> findOrdersByUser(@Param("userId") Pageable pageable, int userId);
}
