package com.example.demo.repository;

import com.example.demo.entity.Cart;
import com.example.demo.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {
    //SELECT * from cart_detail c WHERE c.cart_id = 7
    @Query(value = "SELECT * from cart_detail c " +
            "WHERE c.cart_id = :cartId ",nativeQuery = true)
    List<CartDetail> findByCartId(@Param("cartId") int id);

    @Query(value = "SELECT * from cart_detail c " +
            "WHERE c.book_id = :bookId AND c.cart_id = :cartId",nativeQuery = true)
    CartDetail findCartByBookIdAndCartID(@Param("bookId") int bookId, @Param("cartId") int cartId);
}
