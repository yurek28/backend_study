package com.example.todo_api.member;

import com.example.todo_api.member.Member;
import com.example.todo_api.member.MemberRepository;
import com.example.todo_api.member.MemberService;
import com.example.todo_api.todo.Todo;
import com.example.todo_api.todo.TodoRepository;
import com.example.todo_api.todo.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {
    @Mock
    private MemberRepository memberRepository;
    @InjectMocks
    private MemberService memberService;
    @Test
    public void registerTest() throws Exception {
        memberService.register("idid", "1234");
        Mockito.verify(memberRepository, times(1)).save(any(Member.class));
    }
}