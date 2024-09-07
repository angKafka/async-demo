package org.rdutta.localaccounts.enums;

import io.jsonwebtoken.lang.Collections;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.rdutta.localaccounts.utilities.Permissions;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



@RequiredArgsConstructor
public enum Roles {
    USERS(Collections.emptySet()),
    ADMINS(
            Set.of(
                    Permissions.ADMIN_READ,
                    Permissions.ADMIN_UPDATE,
                    Permissions.ADMIN_CREATE,
                    Permissions.ADMIN_DELETE
            )
           ),

    DEVELOPERS(
            Set.of(
                    Permissions.DEVELOPERS_READ,
                    Permissions.DEVELOPERS_UPDATE,
                    Permissions.DEVELOPERS_CREATE,
                    Permissions.DEVELOPERS_DELETE
            )
               ),

    SUPERVISORS(
           Set.of(
                   Permissions.SUPERVISORS_READ,
                   Permissions.SUPERVISORS_UPDATE,
                   Permissions.SUPERVISORS_CREATE,
                   Permissions.SUPERVISORS_DELETE
           )
    ),

    SUPER_USERS(
           Set.of(
                   Permissions.SUPER_USERS_READ,
                   Permissions.SUPER_USERS_UPDATE,
                   Permissions.SUPER_USERS_CREATE,
                   Permissions.SUPER_USERS_DELETE
           )
    );


    @Getter
    private final Set<Permissions> permissions;


    public List<SimpleGrantedAuthority> getGrantedAuthorities() {
        var authorities = getPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.getGetPermissions()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}