package com.example.libaraymanagementsystem.service.Impl;

import com.example.libaraymanagementsystem.dto.BookDto;
import com.example.libaraymanagementsystem.entity.BookEntity;
import com.example.libaraymanagementsystem.repository.BookRepository;
import com.example.libaraymanagementsystem.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

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
}
