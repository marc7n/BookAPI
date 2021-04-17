package pl.coderslab.service;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MemoryBookService implements BookService {
    private List<Book> bookList;
    private static Long nextId = 4L;

    public MemoryBookService() {
        bookList = new ArrayList<>();
        bookList.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        bookList.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        bookList.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public MemoryBookService setBookList(List<Book> bookList) {
        this.bookList = bookList;
        return this;
    }

    public static Long getNextId() {
        return nextId;
    }

    public static void setNextId(Long nextId) {
        MemoryBookService.nextId = nextId;
    }

    @Override
    public List<Book> getBooks() {
        return bookList;
    }

    @Override
    public Optional<Book> getBook(Long id) {
        return bookList.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    @Override
    public void addBook(Book book) {
        book.setId(nextId++);
        bookList.add(book);
    }

    @Override
    public Book updateBook(Book book) {
        if (this.getBook(book.getId()).isPresent()) {
            int index = bookList.indexOf(this.getBook(book.getId()).get());
            bookList.set(index, book);
        }
        return book;
    }

    @Override
    public void deleteBook(Long id) {
        if (getBook(id).isPresent()) {
            bookList.remove(this.getBook(id).get());
        }
    }
}