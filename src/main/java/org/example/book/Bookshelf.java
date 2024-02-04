package org.example.book;

import java.util.ArrayList;
import java.util.List;

public class Bookshelf {
    List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("book must not be null.");
        }

        books.add(book);
    }

    public Book findBookById(int id) {
        return books.stream()
                .filter(b -> b.id() == id)
                .findFirst().orElseThrow(() -> new BookNotFoundException("book id is not found."));
    }
}
