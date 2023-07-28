package com.blogcodeabkn.backend.blog.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.graphql.server.webflux.GraphiQlHandler;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


public class GraphiQLConfiguration {

    public RouterFunction<ServerResponse> graphiQlRouterFunction() {
        RouterFunctions.Builder builder = RouterFunctions.route();
        ClassPathResource graphiQlPage = new ClassPathResource("graphiql/index.html");
        GraphiQlHandler graphiQLHandler = new GraphiQlHandler("/graphql", "", graphiQlPage);
        builder = builder.GET("/graphiql", graphiQLHandler::handleRequest);
        return builder.build();
    }
}
