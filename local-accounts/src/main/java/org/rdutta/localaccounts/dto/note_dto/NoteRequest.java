package org.rdutta.localaccounts.dto.note_dto;

import jakarta.validation.constraints.NotNull;
import org.rdutta.localaccounts.utilities.features.messages.ErrorMessages;

import java.time.LocalDateTime;

public record NoteRequest(
        @NotNull(message = ErrorMessages.CONTENT_EMPTY)
        String content,
        @NotNull(message = ErrorMessages.CONTENT_TYPE_EMPTY)
        String noteType,
        LocalDateTime noteCreatedDate
) {
}
