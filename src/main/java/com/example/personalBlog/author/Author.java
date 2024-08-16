package com.example.personalBlog.author;

import com.example.personalBlog.article.Article;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.beans.ConstructorProperties;
import java.util.List;


@Entity
@Getter @Setter
@Table(name = "Author")
@RequiredArgsConstructor
public class Author {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "pwd")
    private String pwd;
    @Column(name = "role")
    private String role;

    @OneToMany (mappedBy = "author")
    private List<Article> articles;


    public Author(String username, String email, String pwd, List<Article> articles, List<GrantedAuthority> authorities) {
    }
}
