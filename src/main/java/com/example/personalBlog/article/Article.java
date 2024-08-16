package com.example.personalBlog.article;

import com.example.personalBlog.author.Author;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "article")
@Getter @Setter
@RequiredArgsConstructor
public class Article {
    @Id()
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private Author author;

    @Column(name = "state")
    private String state;
    @Column(name = "readcount")
    private Integer read_count;
    @Column(name = "reading_time")
    private Integer reading_time;

}
