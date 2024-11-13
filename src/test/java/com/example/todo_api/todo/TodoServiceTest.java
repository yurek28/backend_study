package com.example.todo_api.todo;

import com.example.todo_api.member.Member;
import com.example.todo_api.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {
    @Mock
    private TodoRepository todoRepository;
    @Mock
    private MemberRepository memberRepository;
    @InjectMocks
    private TodoService todoService;
    @Test
    public void createTodoTest() throws Exception{
        BDDMockito.given(memberRepository.findById(1L)).willReturn(new Member());
        todoService.createTodo("content", 1L);
        Mockito.verify(todoRepository, times(1)).save(any(Todo.class));
    }
    @Test
    public void readTodosTest() throws Exception{
        Member member = new Member();
        BDDMockito.given(memberRepository.findById(1L)).willReturn(member);
        todoService.readTodos(1L);
        Mockito.verify(memberRepository, times(1)).findById(1L);
    }
    @Test
    public void updatdTodoTest() throws Exception{
        Todo todo = new Todo();
        BDDMockito.given(todoRepository.findById(1L)).willReturn(todo);
<<<<<<< HEAD
        todoService.updateTodo(1L, 1, "new content");
=======
        todoService.updateTodo(1L, "new content");
>>>>>>> 74004ae4c9e6d7a00a503d7c5b2654f47bc1147e
        Mockito.verify(todoRepository, times(1)).findById(1L);

    }
    @Test
    public void deleteTodoTest() throws Exception{
        todoService.deleteTodo(1L);
        Mockito.verify(todoRepository, times(1)).deleteById(1L);
    }
    @Test
    public void checkTodoTest(){
        Todo todo = new Todo();
        BDDMockito.given(todoRepository.findById(1L)).willReturn(todo);
        todoService.todoCheck(1L);
        Mockito.verify(todoRepository, times(1)).findById(1L);
    }
    @Test
    public void uncheckTodoTest(){
        Todo todo = new Todo();
        BDDMockito.given(todoRepository.findById(1L)).willReturn(todo);
        todoService.todoUncheck(1L);
        Mockito.verify(todoRepository, times(1)).findById(1L);
    }

}
