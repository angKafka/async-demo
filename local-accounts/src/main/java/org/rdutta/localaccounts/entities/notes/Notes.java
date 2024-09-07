package org.rdutta.localaccounts.entities.notes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.rdutta.localaccounts.enums.NoteType;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notes")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTES_ID", nullable = false, updatable = false, unique = true)
    private long notes_id;
    @Column(name = "NOTE_CONTENT", nullable = false, length = 1000)
    private String note_content;
    @Enumerated(EnumType.STRING)
    private NoteType note_type;
    @CreationTimestamp
    @Column(name = "NOTE_DATE", nullable = false, updatable = false)
    private LocalDateTime note_date;
}
