package com.example.todo_api.bean;

import org.springframework.stereotype.Component;

@Component
public class MyRepository {
    public void repositoryMethod() {
        System.out.println("repository");
    }
}
