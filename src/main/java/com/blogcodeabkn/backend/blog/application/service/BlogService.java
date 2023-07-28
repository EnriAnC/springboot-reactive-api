package com.blogcodeabkn.backend.blog.application.service;

import com.blogcodeabkn.backend.blog.domain.Blog;
import com.blogcodeabkn.backend.blog.domain.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    public final IBlogRepository blogRepository;

    @Autowired
    public BlogService (IBlogRepository blogRepository, ReactiveMongoTemplate template){
        this.blogRepository = blogRepository;
    }

    @Override
    public Flux<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    public Mono<Blog> findById(Integer id) {
        return this.blogRepository.findByIdBlog(id);
    }

    public void createBlog(Blog blog){

    }

}
