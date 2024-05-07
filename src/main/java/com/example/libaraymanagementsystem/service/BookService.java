package com.example.libaraymanagementsystem.service;

import com.example.libaraymanagementsystem.dto.BookDto;
import com.example.libaraymanagementsystem.entity.BookEntity;

import java.util.List;

public interface BookService {
    BookEntity addBook(BookDto bookDto);
    List<BookDto> getBooks();
}
