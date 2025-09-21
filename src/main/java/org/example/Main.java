package org.example;

import org.example.book.Book;
import org.example.library.LibraryService;
import org.example.loansystem.InMemoryLibraryInventory;
import org.example.loansystem.LibraryInventory;
import org.example.loansystem.Loan;
import org.example.patron.InMemoryPatronRepository;
import org.example.patron.Patron;
import org.example.patron.PatronRepository;

import java.util.List;
import java.util.Optional;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LibraryInventory inventory = new InMemoryLibraryInventory();
        PatronRepository patronRepo = new InMemoryPatronRepository();
        LibraryService service = new LibraryService(inventory, patronRepo);


// sample data
        Book b1 = new Book("b1","Effective Java","FirstName","9780134685991",2018);
        Book b2 = new Book("b2","Clean Code","Second Name","9780132350884",2008);
        Book b3 = new Book("b3","Head First Java","Third Name","9780596009205",2005);
        service.addBook(b1); service.addBook(b2); service.addBook(b3);


        Patron p1 = new Patron("p1","Alice","alice@example.com");
        Patron p2 = new Patron("p2","Bob","bob@example.com");
        service.addPatron(p1); service.addPatron(p2);


// search
        List<Book> search = service.searchByTitle("Java");
        System.out.println("Search results for 'java': " + search);


// checkout
        Optional<Loan> loanOpt = service.checkoutBook("b1","p1");
        System.out.println("Checkout result: " + loanOpt);


// try double checkout -> should fail
        Optional<Loan> loanOpt2 = service.checkoutBook("b1","p2");
        System.out.println("Second checkout (should be empty): " + loanOpt2);


// return
        boolean returned = service.returnBook("b1","p1");
        System.out.println("Returned b1: " + returned);


// list active loans
        System.out.println("Active loans: " + service.listActiveLoans());


// print patron history
        System.out.println("Alice history: " + p1.getBorrowingHistory());


// update book
        Book updated = new Book("b1","Effective Java (3rd Edition)","Joshua Bloch","9780134685991",2018);
        service.updateBook("b1", updated);
        System.out.println("Updated book: " + service.listAllBooks());
    }
}