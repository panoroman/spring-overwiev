package com.example.library.Controller;

import com.example.library.Model.Books;
import com.example.library.Repository.BooksRepository;
import com.example.library.Service.BooksService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class BooksController {

    @Autowired
    private BooksRepository booksRepository;

    @Autowired
    private BooksService booksService;

    @GetMapping("/books")
    public List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Optional<Books> getBook(@PathVariable long id) {
        return booksService.getBook(id);
    }

    @PostMapping("/books")
    public Books createBook(@RequestBody Books books) {
        return booksService.createBook(books);
    }

    @PutMapping("/books/{id}")
    public Books updateBook(@RequestBody Books updBooks, @PathVariable long id) {
        return booksService.updateBook(updBooks, id);
    }

    @PatchMapping("/books/{id}")
    public Books patchBook(@RequestBody Books updBooks, @PathVariable long id) {
        return booksService.patchBook(updBooks, id);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable long id) {
        booksService.deleteBook(id);
    }
}
