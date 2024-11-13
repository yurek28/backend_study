package com.example.todo_api.todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoResponse {
    private long memberId;
    private String content;
}
