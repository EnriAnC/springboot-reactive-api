package com.blogcodeabkn.backend.blog.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("blogs")
public class Blog {

    @Id
    private String _id;
    private Integer id;
    private String title;
    private String description;
    private String body;
    private String img;
    private String author;
    private String date;
    private List<String> tags;
    private int likes;
    private List<Comment> comments;

}
