package org.example.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookshelfTest {
    Bookshelf bookshelf;

    @BeforeEach
    void setup() {
        bookshelf = new Bookshelf();
    }

    @Test
    @DisplayName("add clean code book to bookshelf and bookshelf should contain clean code book")
    void addCleanCodeBook() {
        Book book = new Book(1, "Clean code");

        bookshelf.addBook(book);

        String expected = "Clean code";
        assertEquals(expected, bookshelf.findBookById(1).title());
    }

    @Test
    @DisplayName("should throw IllegalArgumentException when add empty book")
    void addEmptyBookShouldThrowIllegalArgumentException() {
        var exception = assertThrows(IllegalArgumentException.class, () -> bookshelf.addBook(null));

        assertEquals("book must not be null.", exception.getMessage());
    }

    @Test
    @DisplayName("should throw BookNotFoundException when find by id in empty bookshelf")
    void findByIdInEmptyBookshelf() {
        bookshelf = new Bookshelf();

        assertThrows(BookNotFoundException.class, () -> bookshelf.findBookById(1));
    }

    @Test
    @DisplayName("should throw BookNotFoundException with message book id is not found. when find by id in empty bookshelf")
    void findByIdInEmptyBookshelfShouldGetExceptionBookNotFoundException() {
        bookshelf = new Bookshelf();

        var exception = assertThrows(BookNotFoundException.class, () -> bookshelf.findBookById(1));

        assertEquals("book id is not found.", exception.getMessage());
    }
}