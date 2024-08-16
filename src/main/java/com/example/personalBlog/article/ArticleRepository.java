package com.example.personalBlog.article;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Override
    Optional<Article> findById(Long aLong);
}
