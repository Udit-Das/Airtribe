package org.example.patron;

import java.util.List;
import java.util.Optional;

public interface PatronRepository {
    void addPatron(Patron patron);
    Optional<Patron> findById(String patronId);
    Optional<Patron> updatePatron(String patronId, Patron updated);
    List<Patron> listAll();
}
