package org.example.library;

import org.example.book.Book;
import org.example.loansystem.LibraryInventory;
import org.example.loansystem.Loan;
import org.example.patron.Patron;
import org.example.patron.PatronRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LibraryService {
    private final LibraryInventory inventory;
    private final PatronRepository patronRepo;


    // active loans by bookId
    private final Map<String, Loan> activeLoans = new ConcurrentHashMap<>();


    public LibraryService(LibraryInventory inventory, PatronRepository patronRepo) {
        this.inventory = inventory;
        this.patronRepo = patronRepo;
    }


    public void addBook(Book book) { inventory.addBook(book); }
    public boolean removeBook(String bookId) { return inventory.removeBookById(bookId); }
    public Optional<Book> updateBook(String bookId, Book updated) { return inventory.updateBook(bookId, updated); }


    public void addPatron(Patron patron) { patronRepo.addPatron(patron); }
    public Optional<Patron> updatePatron(String patronId, Patron updated) { return patronRepo.updatePatron(patronId, updated); }


    public List<Book> searchByTitle(String title) { return inventory.searchByTitle(title); }
    public List<Book> searchByAuthor(String author) { return inventory.searchByAuthor(author); }
    public Optional<Book> searchByIsbn(String isbn) { return inventory.searchByIsbn(isbn); }


    /** Checkout flow: checks availability then creates a Loan and updates states */
    public synchronized Optional<Loan> checkoutBook(String bookId, String patronId) {
        Optional<Book> ob = inventory.findById(bookId);
        Optional<Patron> op = patronRepo.findById(patronId);
        if (ob.isEmpty() || op.isEmpty()) return Optional.empty();
        Book book = ob.get();
        Patron patron = op.get();
        if (!book.isAvailable()) return Optional.empty();


// create loan
        String loanId = UUID.randomUUID().toString();
        Loan loan = new Loan(loanId, bookId, patronId);
        activeLoans.put(bookId, loan);
        book.setAvailable(false);


// add to patron history (current loan as null returnDate)
        patron.addLoanToHistory(loan);
        return Optional.of(loan);
    }


    /** Return flow */
    public synchronized boolean returnBook(String bookId, String patronId) {
        Loan loan = activeLoans.get(bookId);
        if (loan == null) return false; // not loaned
        if (!loan.getPatronId().equals(patronId)) return false; // wrong patron


        loan.setReturnDate(LocalDate.now());
        activeLoans.remove(bookId);
        inventory.findById(bookId).ifPresent(b -> b.setAvailable(true));
// the loan object is already in patron's history; updated with returnDate
        return true;
    }


    public Optional<Loan> getActiveLoanForBook(String bookId) {
        return Optional.ofNullable(activeLoans.get(bookId));
    }


    public List<Loan> listActiveLoans() { return new ArrayList<>(activeLoans.values()); }


    public List<Book> listAllBooks() { return inventory.listAll(); }
    public List<Patron> listAllPatrons() { return patronRepo.listAll(); }
}
