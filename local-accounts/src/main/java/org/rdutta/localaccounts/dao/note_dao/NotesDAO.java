package org.rdutta.localaccounts.dao.note_dao;

import org.rdutta.localaccounts.dto.note_dto.NoteRequest;
import org.rdutta.localaccounts.entities.notes.Notes;

import java.util.List;

public interface NotesDAO {
    Long create(NoteRequest notes);
    Notes update(NoteRequest notes);
    Notes delete(Long notes_id);
    List<Notes> getAllNotes();
    Notes getNotes(Long notes_id);
}
