package com.example.personalBlog.author;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import com.example.personalBlog.config.PersonalBlogSecurityConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorService authorService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Author author) {
        return authorService.registerUser(author);
    }

    @GetMapping("/authors")
    public List<Author> findAllAuthors(){
        return authorService.findAllAuthors();
    }

    @GetMapping("/myAccount")
    public String myAccount(){
        return "My Account Details";
    }

    @GetMapping("/myArticles")
    public String myArticles() {
        return "My Article details";
    }

    @GetMapping("/error")
    public String error() {
        return "some error";
    }

}
