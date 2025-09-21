package org.example.loansystem;

import org.example.book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryLibraryInventory implements LibraryInventory {
    private final Map<String, Book> books = new ConcurrentHashMap<>();

    @Override
    public void addBook(Book book) {
        books.put(book.getId(), book);
    }


    @Override
    public boolean removeBookById(String bookId) {
        return books.remove(bookId) != null;
    }
    @Override
    public Optional<Book> updateBook(String bookId, Book updated) {
        return Optional.ofNullable(books.computeIfPresent(bookId, (id, old) -> {
        old.setTitle(updated.getTitle());
        old.setAuthor(updated.getAuthor());
        old.setIsbn(updated.getIsbn());
        old.setPublicationYear(updated.getPublicationYear());
        return old;
    }));
}


    @Override
    public Optional<Book> findById(String bookId) {
        return Optional.ofNullable(books.get(bookId));
    }


    @Override
    public List<Book> searchByTitle(String title) {
        String t = title.toLowerCase();
        return books.values().stream()
                .filter(b -> b.getTitle().toLowerCase().contains(t))
                .collect(Collectors.toList());
    }


    @Override
    public List<Book> searchByAuthor(String author) {
        String a = author.toLowerCase();
        return books.values().stream()
                .filter(b -> b.getAuthor().toLowerCase().contains(a))
                .collect(Collectors.toList());
    }


    @Override
    public Optional<Book> searchByIsbn(String isbn) {
        return books.values().stream()
                .filter(b -> b.getIsbn().equalsIgnoreCase(isbn))
                .findFirst();
    }


    @Override
    public List<Book> listAll() {
        return new ArrayList<>(books.values());
    }
}

