package pl.coderslab.service;

import pl.coderslab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();
    Optional<Book> getBook(Long id);
    void addBook(Book book);
    Book updateBook(Book book);
    void deleteBook(Long id);
}