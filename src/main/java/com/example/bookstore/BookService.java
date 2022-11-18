package com.example.bookstore;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book findBookByAuthorName(String author){
        return bookRepository.findAllByAuthor(author);
    }

    public Book findBookByTitle(String title){
        return bookRepository.findAllByTitle(title);
    }

    public List<Book> findBooks(){
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }
}
