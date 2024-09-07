package org.rdutta.localaccounts.utilities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permissions {
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),


    DEVELOPERS_READ("developers:read"),
    DEVELOPERS_UPDATE("developers:update"),
    DEVELOPERS_CREATE("developers:create"),
    DEVELOPERS_DELETE("developers:delete"),


    SUPERVISORS_READ("supervisor:read"),
    SUPERVISORS_UPDATE("supervisor:update"),
    SUPERVISORS_CREATE("supervisor:create"),
    SUPERVISORS_DELETE("supervisor:delete"),


    SUPER_USERS_READ("super_users:read"),
    SUPER_USERS_UPDATE("super_users:update"),
    SUPER_USERS_CREATE("super_users:create"),
    SUPER_USERS_DELETE("super_users:delete")
    ;

    @Getter
    private final String getPermissions;
}