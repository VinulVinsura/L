package com.example.libaraymanagementsystem.repository;

import com.example.libaraymanagementsystem.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity,Integer> {
}
