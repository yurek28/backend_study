package com.example.todo_api.todo.dto;

import lombok.Getter;

@Getter
public class TodoUpdateRequest {
    private long memberId;
    private String updateContent;
}
