package com.blogcodeabkn.backend.blog.application.service;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


public class GraphQLService {
    public final GraphQL graphQL;

    @Autowired
    public GraphQLService(GraphQL graphQL) {
        this.graphQL = graphQL;
    }

    public ExecutionResult execute(Map<String, Object> request) {
        ExecutionInput executionInput = ExecutionInput.newExecutionInput()
                .query((String) request.get("query"))
                .operationName((String) request.get("operationName"))
                .variables((Map<String, Object>) request.get("variables"))
                .build();
        return graphQL.execute(executionInput);
    }
}
