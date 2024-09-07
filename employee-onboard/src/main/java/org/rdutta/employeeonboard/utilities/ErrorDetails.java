package org.rdutta.employeeonboard.utilities;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private int errorCode;
    private String errorMessage;
    private LocalDateTime timestamp;
}
