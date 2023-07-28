package com.blogcodeabkn.backend.blog.domain;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IBlogRepository {

    Flux<Blog> findAll ();
    Mono<Blog> findByIdBlog (Integer id);

    void createBlog (Blog blog);

}
