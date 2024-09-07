package org.rdutta.localaccounts.utilities.features.mapper;

import org.rdutta.localaccounts.dto.note_dto.NoteRequest;
import org.rdutta.localaccounts.entities.notes.Notes;
import org.rdutta.localaccounts.enums.NoteType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotesMapper {
    public Notes toNotes(NoteRequest note) {
        return Notes.builder()
                .note_content(note.content())
                .note_type(NoteType.valueOf(note.noteType()))
                .note_date(LocalDateTime.now())
                .build();
    }
}
