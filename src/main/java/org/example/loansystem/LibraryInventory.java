package org.example.loansystem;

import org.example.book.Book;

import java.util.List;
import java.util.Optional;

public interface LibraryInventory {
    void addBook(Book book);
    boolean removeBookById(String bookId);
    Optional<Book> updateBook(String bookId, Book updated);


    Optional<Book> findById(String bookId);
    List<Book> searchByTitle(String title);
    List<Book> searchByAuthor(String author);
    Optional<Book> searchByIsbn(String isbn);
    List<Book> listAll();
}
