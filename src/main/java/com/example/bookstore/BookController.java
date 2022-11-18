package com.example.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    public BookController() {
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @GetMapping("/books/{author}")
    public ResponseEntity<Book> getBookByAuthor(@PathVariable("author") String author){
        return ResponseEntity.ok(bookService.findBookByAuthorName(author));
    }

    @GetMapping("/books/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable("title") String title){
        return ResponseEntity.ok(bookService.findBookByTitle(title));
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.findBooks());
    }

    @PostMapping("/book")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.ok("book added");
    }


}
