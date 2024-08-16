package com.example.personalBlog.author;

import com.example.personalBlog.article.ArticleDTO;
import com.example.personalBlog.article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService implements UserDetailsService {
    private final AuthorRepository authorRepository;
    private final PasswordEncoder passwordEncoder;
    private final ArticleService articleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Author author = authorRepository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("user details not found for the user "+ username));

        List<GrantedAuthority> authorities= List.of(new SimpleGrantedAuthority(author.getRole()));
        return new User(author.getEmail(), author.getPwd(),authorities);
    }


    public ResponseEntity<String> registerUser(Author author) {
        try {
            // Check if the user already exists
            if (authorRepository.findByEmail(author.getEmail()).isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists with this email");
            }

            // Encode the password
            String hashedPwd = passwordEncoder.encode(author.getPwd());
            author.setPwd(hashedPwd);

            // Save the user to the repository
            Author savedAuthor = authorRepository.save(author);

            if (savedAuthor.getId() > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body("User has been registered successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getMessage());
        }
    }

    public List<Author> findAllAuthors(){
        return (List<Author>) authorRepository.findAll();
    }

    @PostMapping("/myArticles/post")
    public ResponseEntity<String> createArticle(@RequestBody ArticleDTO articleDTO) {
        return articleService.createArticle(articleDTO);
    }
}
