package com.example.libaraymanagementsystem.controller;

import com.example.libaraymanagementsystem.dto.BookDto;
import com.example.libaraymanagementsystem.dto.Response;
import com.example.libaraymanagementsystem.entity.BookEntity;
import com.example.libaraymanagementsystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
@CrossOrigin
@RequiredArgsConstructor // All final varibles are inject
public class BookController {
    Response response=new Response();

    final BookService bookService;
    @PostMapping("/addBook")
    @ResponseStatus(HttpStatus.CREATED) //HTTP status of our post method
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


    @GetMapping("/getBookList")
    public List<BookDto> getBookList(){
        return bookService.getBooks();


    }
    @DeleteMapping("/deletebook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id){
        if (bookService.deleteBook(id)){
            return ResponseEntity.ok("Deleted....");
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/search/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public BookDto searchBookById(@PathVariable Integer id){
        BookDto bookDto = bookService.searchBookById(id);
        if (bookDto!=null){
              return bookDto;
        }
        return null;
    }

    @GetMapping("/searchByIsbn/{isbn}")

    public List<BookDto> searchBookByIsbn(@PathVariable String isbn){
        List<BookDto> bookDtoList = bookService.searchBookByIsbn(isbn);
        System.out.println(bookDtoList);
        return bookDtoList;
    }


}
