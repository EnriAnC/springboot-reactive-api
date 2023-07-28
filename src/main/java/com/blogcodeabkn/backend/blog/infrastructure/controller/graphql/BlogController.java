package com.blogcodeabkn.backend.blog.infrastructure.controller.graphql;

import com.blogcodeabkn.backend.blog.application.service.BlogService;
import com.blogcodeabkn.backend.blog.domain.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class BlogController {
    public final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @CrossOrigin
    @QueryMapping
    public Flux executeGraphQLQuery() {
        return this.blogService.findAll();
    }

    @CrossOrigin
    @ResponseBody
    @GetMapping("/blogs")
    public Flux<Blog> getBlogs() {
        return this.blogService.findAll();
    }

    @PostMapping()
    public void createBlog(){

    }

    @ResponseBody
    @GetMapping("/blogs/{id}")
    public Mono<Blog> getBlogsById(@PathVariable Integer id) {
        return this.blogService.findById(id);
    }
}
