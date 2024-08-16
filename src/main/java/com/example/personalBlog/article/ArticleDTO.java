package com.example.personalBlog.article;

import lombok.Data;

@Data
public class ArticleDTO {
    private String title;
    private String description;
    private String state;
    private Integer read_count;
    private Integer reading_time;
    private Long authorId;
}
