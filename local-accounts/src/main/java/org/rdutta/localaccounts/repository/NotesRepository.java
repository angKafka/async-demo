package org.rdutta.localaccounts.repository;

import org.rdutta.localaccounts.entities.notes.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {
}
