package com.example.todo_api.todo;

import com.example.todo_api.member.Member;
import com.example.todo_api.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final MemberRepository memberRepository;
    @Transactional
<<<<<<< HEAD
    public long createTodo(String content, Long memberId) throws Exception{
=======
    public void createTodo(String content, Long memberId) throws Exception{
>>>>>>> 74004ae4c9e6d7a00a503d7c5b2654f47bc1147e
        Member member = memberRepository.findById(memberId);
        if(member == null){
            throw new Exception("존재하지 않는 멤버입니다.");
        }
        Todo todo = new Todo(content, member);
        todoRepository.save(todo);
<<<<<<< HEAD
        return todo.getId();
=======
>>>>>>> 74004ae4c9e6d7a00a503d7c5b2654f47bc1147e
    }
    @Transactional(readOnly = true)
    public List<Todo> readTodos(Long memberId) throws Exception{
        Member member = memberRepository.findById(memberId);
        if(member == null){
            throw new Exception("존재하지 않는 멤버입니다.");
        }
        return todoRepository.findAllByMember(member);
    }
    @Transactional
<<<<<<< HEAD
    public void updateTodo(Long todoId, long memberId, String newContent) throws Exception{
        Todo todo = todoRepository.findById(todoId);
        Member member = memberRepository.findById(memberId);
=======
    public void updateTodo(Long todoId, String newContent) throws Exception{
        Todo todo = todoRepository.findById(todoId);
>>>>>>> 74004ae4c9e6d7a00a503d7c5b2654f47bc1147e
        todo.updateContent(newContent);
    }
    @Transactional
    public void deleteTodo(Long todoId){
        todoRepository.deleteById(todoId);
    }
    @Transactional
    public void todoCheck(Long todoId){
        Todo todo = todoRepository.findById(todoId);
        todo.check();
    }
    @Transactional
    public void todoUncheck(Long todoId){
        Todo todo = todoRepository.findById(todoId);
        todo.uncheck();
    }
}
