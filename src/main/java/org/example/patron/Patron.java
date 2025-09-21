package org.example.patron;

import org.example.loansystem.Loan;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String id;
    private String name;
    private String email;


    // borrowing history
    private final List<Loan> borrowingHistory = new ArrayList<>();

    public Patron(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Loan> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void addLoanToHistory(Loan loan) {
        borrowingHistory.add(loan);
    }
}
