package com.example.libaraymanagementsystem.repository;

import com.example.libaraymanagementsystem.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BookRepository extends JpaRepository<BookEntity,Integer> {
     List<BookEntity> findByIsbn(String isbn); //Custom Queries in Spring Boot
     List<BookEntity> findByQtyGreaterThan(Integer qty); // We Can Find

}
