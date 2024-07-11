package org.rdutta.userserver.record;



public record MemberRequest(
        String username,
        String email,
        String password,
        int active
) {
}
