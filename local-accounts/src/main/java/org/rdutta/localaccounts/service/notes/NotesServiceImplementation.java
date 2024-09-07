package org.rdutta.localaccounts.service.notes;

import lombok.RequiredArgsConstructor;
import org.rdutta.localaccounts.dao.note_dao.NotesDAO;
import org.rdutta.localaccounts.dto.note_dto.NoteRequest;
import org.rdutta.localaccounts.entities.notes.Notes;
import org.rdutta.localaccounts.repository.NotesRepository;
import org.rdutta.localaccounts.utilities.features.mapper.NotesMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotesServiceImplementation implements NotesDAO {
    private final NotesMapper notesMapper;
    private final NotesRepository notesRepository;

    @Override
    public Long create(NoteRequest notes) {
        Notes note = notesMapper.toNotes(notes);
        return notesRepository.save(note).getNotes_id();
    }

    @Override
    public Notes update(NoteRequest notes) {
        return null;
    }

    @Override
    public Notes delete(Long notes_id) {
        return null;
    }

    @Override
    public List<Notes> getAllNotes() {
        return List.of();
    }

    @Override
    public Notes getNotes(Long notes_id) {
        return null;
    }
}
