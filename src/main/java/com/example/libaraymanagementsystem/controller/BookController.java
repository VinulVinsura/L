package com.example.libaraymanagementsystem.controller;

import com.example.libaraymanagementsystem.dto.BookDto;
import com.example.libaraymanagementsystem.dto.Response;
import com.example.libaraymanagementsystem.entity.BookEntity;
import com.example.libaraymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/book")
@CrossOrigin
public class BookController {
    Response response=new Response();
    @Autowired
    BookService bookService;
    @PostMapping("/addBook")
    public Response addBook(@RequestBody BookDto bookDto){

        BookEntity bookEntity = bookService.addBook(bookDto);
        if (bookEntity!=null){
           response.setId(bookEntity.getId());
           response.setIsbn(bookEntity.getIsbn());
           response.setStatus("Book Added Successful !!!");
           return response;
        }


        response.setStatus("Book Added Unsuccessful !!!");
        return response;


    }


}
