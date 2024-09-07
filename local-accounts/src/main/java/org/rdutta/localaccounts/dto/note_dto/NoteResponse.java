package org.rdutta.localaccounts.dto.note_dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteResponse {
    private long note_id;
    private String note;
    private String note_type;
    private LocalDateTime created_at;
}
