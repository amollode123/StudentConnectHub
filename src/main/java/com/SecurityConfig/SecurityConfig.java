package com.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("src/main/resources/static/Form.html").permitAll() // Replace with the actual path to your form
                .anyRequest().authenticated()
            )
            .formLogin()
            .and()
            .csrf().disable(); // Disable CSRF for simplicity, especially for non-POST forms

        return http.build();
    }
}

