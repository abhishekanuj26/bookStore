package com.example.bookstore;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long>{

    Book findAllByAuthor(String name);

    Book findAllByTitle(String title);

    List<Book> findAll();

}
