package com.example.personalBlog.article;

import com.example.personalBlog.author.Author;
import com.example.personalBlog.author.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final AuthorRepository authorRepository;
    private final ArticleRepository articleRepository;


    public ResponseEntity<String> createArticle(ArticleDTO articleDTO) {
        try {

            Author author = authorRepository.findById(articleDTO.getAuthorId())
                    .orElseThrow(() -> new RuntimeException("Author not found"));

            Article article = new Article();
            article.setTitle(articleDTO.getTitle());
            article.setDescription(articleDTO.getDescription());
            article.setState(articleDTO.getState());
            article.setRead_count(articleDTO.getRead_count());
            article.setReading_time(articleDTO.getReading_time());
            article.setAuthor(author);

            articleRepository.save(article);
            return ResponseEntity.status(HttpStatus.CREATED).body("Article created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating article: " + e.getMessage());
        }
    }


    public List<Article> findArticlesbyUserusername(String username){
        Optional<Author> author = authorRepository.findByUsername(username);
        return author.get().getArticles();

    }

    public List<Article> findArticlesbyId(Long id){
        Optional<Author> author = authorRepository.findById(id);
        return author.get().getArticles();

    }


}
