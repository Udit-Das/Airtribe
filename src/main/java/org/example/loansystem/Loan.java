package org.example.loansystem;

import java.time.LocalDate;
import java.util.Date;

public class Loan {
    private String loanId;
    private String bookId;
    private String patronId;
    private LocalDate checkoutDate;
    private LocalDate returnDate;

    public Loan(String loanId, String bookId, String patronId) {
        this.loanId = loanId;
        this.bookId = bookId;
        this.patronId = patronId;
        this.checkoutDate = LocalDate.now();
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getPatronId() {
        return patronId;
    }

    public void setPatronId(String patronId) {
        this.patronId = patronId;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return returnDate != null;
    }
}
