package com.example.personalBlog.article;

import com.example.personalBlog.author.Author;
import com.example.personalBlog.author.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleRepository articleRepository;
    private final AuthorRepository authorRepository;
    private final ArticleService articleService;


//    @PostMapping("/myArticles/post")
//   public ResponseEntity<String> createArticle(@RequestBody ArticleDTO articleDTO) {
//      return articleService.createArticle(articleDTO);
//   }

    @GetMapping("/search")
    public ResponseEntity<List<Article>> findArticlesbyUserusername(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "id", required = false) Long id) {

        List<Article> articles;

        if (username != null && !username.isEmpty()) {
            articles = articleService.findArticlesbyUserusername(username);
        } else if (id != null) {
            articles = articleService.findArticlesbyId(id);
        } else {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }

        if (articles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        } else {
            return ResponseEntity.ok(articles);
        }
    }

}

