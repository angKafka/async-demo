package org.rdutta.localaccounts.utilities.features;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class ErrorDetails {
    private int errorStatus;
    private String errorMessage;
    public ErrorDetails(int errorStatus, String errorMessage) {
        this.errorStatus = errorStatus;
        this.errorMessage = errorMessage;
    }
}
