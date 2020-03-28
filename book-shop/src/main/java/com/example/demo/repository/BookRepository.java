package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("select b from Book b where b.name = ?1")
    Book myCustomQuery(String name);

    public Page<Book> findByNameLike(Pageable pageable, String name);

    @Query(value = "SELECT * FROM BOOK ORDER BY created_date DESC LIMIT 4", nativeQuery = true)
    List<Book> getNewBooks();

    public Page<Book> findByName(String name, Pageable pageable);

    @Query("SELECT b FROM Book b WHERE (:keyword IS NULL OR UPPER(b.name)"
            + "LIKE CONCAT('%',UPPER(:keyword),'%')) ORDER BY created_date DESC")
    Page<Book> getBooksByKeyword(Pageable pageable, @Param("keyword") String keyword);
}
