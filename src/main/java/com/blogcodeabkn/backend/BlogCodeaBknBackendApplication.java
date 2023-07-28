package com.blogcodeabkn.backend;

import com.blogcodeabkn.backend.blog.infrastructure.repository.MongoDBBlogRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableReactiveMongoRepositories(basePackageClasses = MongoDBBlogRepository.class)
@EnableWebFlux
public class BlogCodeaBknBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogCodeaBknBackendApplication.class, args);
	}

}
