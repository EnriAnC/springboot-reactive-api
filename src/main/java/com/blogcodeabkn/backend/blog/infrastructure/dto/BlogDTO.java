package com.blogcodeabkn.backend.blog.infrastructure.dto;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "blogs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BlogDTO {
    private Integer id;
    private String title;
    private String description;
    private String body;
    private String img;
    private String author;
    private LocalDate date;
    private List<String> tags;
    private int likes;
    private List<Comment> comments;


    static class Comment {
        private String username;
        private String text;
        private LocalDate date;
    }
}
