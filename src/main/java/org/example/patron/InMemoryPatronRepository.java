package org.example.patron;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryPatronRepository implements PatronRepository {
    private final Map<String, Patron> patrons = new ConcurrentHashMap<>();


    @Override
    public void addPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }


    @Override
    public Optional<Patron> findById(String patronId) {
        return Optional.ofNullable(patrons.get(patronId));
    }

    @Override
    public Optional<Patron> updatePatron(String patronId, Patron updated) {
        return Optional.ofNullable(patrons.computeIfPresent(patronId, (id, old) -> {
            old.setName(updated.getName());
            old.setEmail(updated.getEmail());
            return old;
        }));
    }


    @Override
    public List<Patron> listAll() {
        return new ArrayList<>(patrons.values());
    }
}
