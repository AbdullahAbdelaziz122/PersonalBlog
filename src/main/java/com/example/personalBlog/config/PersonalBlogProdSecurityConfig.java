package com.example.personalBlog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;
import org.springframework.stereotype.Component;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Component
@Profile("prod")
public class PersonalBlogProdSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/myAccount", "/myArticles").authenticated()
                .requestMatchers("/welcome", "/notices", "/contacts", "/error", "/register").permitAll());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    //   Check if the password is weak or have been leaked in data breaches

    public CompromisedPasswordChecker compromisedPasswordChecker(){
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }
}