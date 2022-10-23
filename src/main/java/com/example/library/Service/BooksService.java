package com.example.library.Service;

import com.example.library.Model.Books;
import com.example.library.Repository.BooksRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    BooksRepository booksRepository;

    public List<Books> getAllBooks() {
        return booksRepository.findAll();
    }

    public Optional<Books> getBook(@PathVariable long id) {
        return booksRepository.findById(id);
    }

    public Books createBook(@RequestBody Books books) {
        return booksRepository.save(books);
    }

    public Books updateBook(@RequestBody Books updBooks, @PathVariable long id) {
        return booksRepository.findById(id).map(book -> {
            book.setAuthor(updBooks.getAuthor());
            book.setTitle(updBooks.getTitle());
            return booksRepository.save(book);
        }).orElseGet(() -> booksRepository.save(updBooks));
    }

    @SneakyThrows
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

    public void deleteBook(@PathVariable long id) {
        booksRepository.deleteById(id);
    }
}
