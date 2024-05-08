package com.example.libaraymanagementsystem.service.Impl;

import com.example.libaraymanagementsystem.dto.BookDto;
import com.example.libaraymanagementsystem.entity.BookEntity;
import com.example.libaraymanagementsystem.repository.BookRepository;
import com.example.libaraymanagementsystem.service.BookService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;
    ModelMapper modelMapper;
    @Bean
    public void setModelMapper(){
        this.modelMapper=new ModelMapper();
    }
    @Override
    public BookEntity addBook(BookDto bookDto) {
        if (bookDto.getIsbn()!= "" &&
                bookDto.getCategory() != "" &&
                bookDto.getPrice() != null &&
                bookDto.getQty() !=null &&
                bookDto.getTitle() != "")
        {
            return repository.save(modelMapper.map(bookDto, BookEntity.class));

        }
        return null;
    }

    @Override
    public List<BookDto> getBooks() {
        List<BookEntity> bookEntityList = repository.findAll();
        return modelMapper.map(bookEntityList,new TypeToken<List<BookDto>>(){}.getType());
    }

    @Override
    public boolean deleteBook(Integer id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public BookDto searchBookById(Integer id) {
        if (repository.existsById(id)){
            Optional<BookEntity> optionalEntity = repository.findById(id);
            return modelMapper.map(optionalEntity,BookDto.class);
        }
        return null;
    }

    @Override
    public List<BookDto> searchBookByIsbn(String isbn) {

        List<BookEntity> bookList = repository.findByIsbn(isbn);
        System.out.println(bookList);
        return modelMapper.map(bookList,new TypeToken<List<BookDto>>(){}.getType());
    }



}
