package com.example.library.Controller;

import com.example.library.Model.Books;
import com.example.library.Repository.BooksRepository;
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

    @GetMapping("/books")
    public List<Books> getAllBooks() {
        return booksRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Books> getBook(@PathVariable long id) {
        return booksRepository.findById(id);
    }

    @PostMapping("/books")
    public Books createBook(@RequestBody Books books) {
        return booksRepository.save(books);
    }

    @PutMapping("/books/{id}")
    public Books updateBook(@RequestBody Books updBooks, @PathVariable long id) {
        return booksRepository.findById(id).map(book -> {
            book.setAuthor(updBooks.getAuthor());
            book.setTitle(updBooks.getTitle());
            return booksRepository.save(book);
        }).orElseGet(() -> booksRepository.save(updBooks));
    }

    @SneakyThrows
    @PatchMapping("/books/{id}")
    public Books patchBook(@RequestBody Books updBooks, @PathVariable long id) {
        Books book = booksRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        if(updBooks.getAuthor() != null) {
            book.setAuthor(updBooks.getAuthor());
        }
        if(updBooks.getTitle() != null) {
            book.setTitle(updBooks.getTitle());
        }
        return booksRepository.save(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable long id) {
        booksRepository.deleteById(id);
    }
}
