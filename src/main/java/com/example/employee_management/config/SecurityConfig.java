package com.example.employee_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register", "/login").permitAll()

                        // ai cung duoc xem ds
                        .requestMatchers(org.springframework.http.HttpMethod.GET, "/employees").hasAnyRole("USER", "ADMIN")

                        // chi admin them xoa sua
                        .requestMatchers(HttpMethod.GET, "/employees").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/employees/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/employees/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/employees/**").hasRole("ADMIN")

                        .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginProcessingUrl("/login")
                        .permitAll()
                );

        return http.build();
    }
}