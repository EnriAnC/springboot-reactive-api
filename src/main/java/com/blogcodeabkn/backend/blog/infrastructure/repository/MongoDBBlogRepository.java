package com.blogcodeabkn.backend.blog.infrastructure.repository;

import com.blogcodeabkn.backend.blog.domain.Blog;
import com.blogcodeabkn.backend.blog.domain.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class MongoDBBlogRepository implements IBlogRepository {

    private final ReactiveMongoTemplate mongoTemplate;

    @Autowired
    protected MongoDBBlogRepository(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Mono<Blog> findByIdBlog (Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, Blog.class);
    }

    @Override
    public Flux<Blog> findAll(){
        return mongoTemplate.findAll(Blog.class);
    }

    @Override
    public void createBlog(Blog blog){
        mongoTemplate.insert(blog);
    }

}