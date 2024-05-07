package com.example.libaraymanagementsystem.service;

import com.example.libaraymanagementsystem.dto.BookDto;
import com.example.libaraymanagementsystem.entity.BookEntity;

public interface BookService {
    BookEntity addBook(BookDto bookDto);
}
