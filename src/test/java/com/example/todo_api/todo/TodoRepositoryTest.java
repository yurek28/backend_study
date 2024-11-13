package com.example.todo_api.todo;

import com.example.todo_api.member.Member;
import com.example.todo_api.member.MemberRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TodoRepositoryTest {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Test
    @Transactional
    @Rollback(value = false)
    void todoSaveTest(){
        Todo todo = new Todo("todo_content",  null);
        todoRepository.save(todo);
        Assertions.assertThat(todo.getId()).isNotNull();
    }
    @Test
    @Transactional
    void todoFindOneByIdTest(){
        Todo todo = new Todo("todo_content",  null);
        todoRepository.save(todo);
        todoRepository.flushAndClear();
        Todo findTodo = todoRepository.findById(todo.getId());
        Assertions.assertThat(findTodo.getId()).isEqualTo(todo.getId());
    }
    @Test
    @Transactional
    void todoFindAllTest(){
        Todo todo1 = new Todo("todo_content1",  null);
        Todo todo2 = new Todo("todo_content2",  null);
        Todo todo3 = new Todo("todo_content3",  null);
        todoRepository.save(todo1);
        todoRepository.save(todo2);
        todoRepository.save(todo3);
        List<Todo> todoList = todoRepository.findAll();
        System.out.println(todoList);
        Assertions.assertThat(todoList).hasSize(3);
    }
    @Test
    @Transactional
    void todoFindAllByMemberTest(){
        Member member1 = new Member();
        Member member2 = new Member();
        memberRepository.save(member1);
        memberRepository.save(member2);
        Todo todo1 = new Todo("todo_content1",  member1);
        Todo todo2 = new Todo("todo_content2",  member1);
        Todo todo3 = new Todo("todo_content3", member2);
        todoRepository.save(todo1);
        todoRepository.save(todo2);
        todoRepository.save(todo3);
        List<Todo> member1TodoList = todoRepository.findAllByMember(member1);
        List<Todo> member2TodoList = todoRepository.findAllByMember(member2);
        Assertions.assertThat(member1TodoList).hasSize(2);
        Assertions.assertThat(member2TodoList).hasSize(1);
    }
    @Test
    @Transactional
    @Rollback(value = false)
    void todoUpdateTest(){
        Todo todo = new Todo("todo_content",  null);
        todoRepository.save(todo);
        todoRepository.flushAndClear();
        Todo findTodo = todoRepository.findById(todo.getId());
        findTodo.updateContent("new content");
        Assertions.assertThat(todo.getContent()).isNotEqualTo(findTodo.getContent());
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void todoDeleteTest(){
        Todo todo1 = new Todo("todo_content",  null);
        Todo todo2 = new Todo("todo_content",  null);
        todoRepository.save(todo1);
        todoRepository.save(todo2);
        todoRepository.flushAndClear();
        todoRepository.deleteById(todo1.getId());
        Todo testTodo = todoRepository.findById(todo1.getId());
        Assertions.assertThat(testTodo).isNull();
    }
    @AfterAll
    static void test(){
        System.out.println("test finish");
        while(true){}
    }
}
