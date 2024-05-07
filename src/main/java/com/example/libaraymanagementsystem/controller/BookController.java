package com.example.libaraymanagementsystem.controller;

import com.example.libaraymanagementsystem.dto.BookDto;
import com.example.libaraymanagementsystem.entity.BookEntity;
import com.example.libaraymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/book")
@CrossOrigin
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public BookEntity addBook(@RequestBody BookDto bookDto){
         return bookService.addBook(bookDto);
    }


}
