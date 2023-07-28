package com.blogcodeabkn.backend.blog.application.service;

import com.blogcodeabkn.backend.blog.domain.Blog;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBlogService {
    Flux<Blog> findAll();

    Mono<Blog> findById(Integer id);

    void createBlog(Blog blog);
}
