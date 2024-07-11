package org.rdutta.userserver.record;

import java.io.Serializable;
import java.util.UUID;

public record MemberResponse(
        UUID member_id,
        String username,
        String email,
        String password
) implements Serializable {
}
