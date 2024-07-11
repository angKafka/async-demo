package org.rdutta.crm.security;

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
public class SecurityConfiguration {

    // Add support for JDBC... no more hardcoded users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager judm =  new JdbcUserDetailsManager(dataSource);
        // define query to retrieve user by username
        judm.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id = ?");
        // define query to retrieve the authorities or role by username
        judm.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id = ?");

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
                        .requestMatchers(HttpMethod.GET, "/api/v1/employee/")
                        .hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,  "/api/v1/employee/**")
                        .hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/v1/employee/**")
                        .hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/employee/**")
                        .hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/employee/**")
                        .hasRole("ADMIN"));

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());
        return http.build();
    }


    /*@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails raj = User.builder()
                .username("raj")
                .password("{noop}Prerna@12345")
                .roles("EMPLOYEE")
                .build();
        UserDetails prerna = User.builder()
                .username("prerna")
                .password("{noop}Raj@12345")
                .roles("MANAGER")
                .build();
        UserDetails priyanka = User.builder()
                .username("priyanka")
                .password("{noop}Priya@12345")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(raj, prerna, priyanka);
    }
*/
}
