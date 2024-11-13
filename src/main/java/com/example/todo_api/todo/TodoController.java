package com.example.todo_api.todo;

import com.example.todo_api.todo.dto.TodoCreateRequest;
import com.example.todo_api.todo.dto.TodoResponse;
import com.example.todo_api.todo.dto.TodoUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;
    @PostMapping
    public ResponseEntity<Void> createTodo(@RequestBody TodoCreateRequest request) throws Exception {
        long todoId = todoService.createTodo(request.getContent(), request.getMemberId());
        return ResponseEntity.created(URI.create("/todo/"+ todoId)).build();
    }
    @GetMapping ("/list")
    public ResponseEntity<List<Todo>> getTodoList(@RequestBody Long memberId) throws Exception {
        List<Todo> todoList = todoService.readTodos( memberId);
        return ResponseEntity.ok().body(todoList);
    }
    @DeleteMapping ("/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long todoId) throws Exception {
        todoService.deleteTodo(todoId);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping ("/{todoId}")
    public ResponseEntity<Void> updateTodo(@PathVariable Long todoId, @RequestBody TodoUpdateRequest request) throws Exception {
        todoService.updateTodo(todoId, request.getMemberId(), request.getUpdateContent());
        return ResponseEntity.ok().build();
    }
    @PatchMapping ("/{todoId}")
    public ResponseEntity<Void> checkTodo(@PathVariable Long todoId) throws Exception {
        todoService.todoCheck(todoId);
        return ResponseEntity.ok().build();
    }
    @PatchMapping ("/{todoId}")
    public ResponseEntity<Void> uncheckTodo(@PathVariable Long todoId) throws Exception {
        todoService.todoUncheck(todoId);
        return ResponseEntity.ok().build();
    }
}
