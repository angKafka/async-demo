package org.rdutta.assignment.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class BookingSecurity {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager judm = new JdbcUserDetailsManager(dataSource);
        judm.setUsersByUsernameQuery(
                "SELECT USERNAME, PASSWORD, ACTIVE FROM GUEST WHERE USERNAME=?"
        );
        judm.setAuthoritiesByUsernameQuery(
                "SELECT ROLE.USERNAME, ROLE.ROLE FROM ROLE JOIN GUEST ON ROLE.GUEST_ID=GUEST.GUEST_ID WHERE GUEST.USERNAME=?"
        );
        return judm;
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure ->
                configure
                        .requestMatchers(HttpMethod.GET, "/api/v1/bookings/guests/**")
                        .hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/v1/bookings/guests/**")
                        .hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/bookings/guests/**")
                        .hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/bookings/guests/**")
                        .hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/v1/bookings/reservations/**")
                        .hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/v1/bookings/reservations/**")
                        .hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/bookings/reservations/**")
                        .hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/bookings/reservations/**")
                        .hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/v1/bookings/rooms/**")
                        .hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/v1/bookings/rooms/**")
                        .hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/bookings/rooms/**")
                        .hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/bookings/rooms/**")
                        .hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
