package com.example.library.Controller;

import com.example.library.Model.Books;
import com.example.library.Repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books/")
public class BooksController {

    @Autowired
    private BooksRepository booksRepository;

    @GetMapping("/{id}")
    public List<Books> getAllBooks() {
        return this.booksRepository.findAll();
    }

//    @GetMapping("/books/{id}")
//    public Resp

    @PostMapping("/")
    public Books createBooks(@RequestBody Books books) {
        return this.booksRepository.save(books);
    }

//    @PutMapping("books/{id}")
//    public ResponseEntity<Books> updateBooks(@RequestBody Books books) {
//        return this.booksRepository.save(books);
//    }
}
