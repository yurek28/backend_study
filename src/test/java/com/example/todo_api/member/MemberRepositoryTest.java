package com.example.todo_api.member;

import com.example.todo_api.todo.Todo;
import com.example.todo_api.todo.TodoRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void memberSaveTest(){
        Member member = new Member();
        memberRepository.save(member);
        Assertions.assertThat(member.getId()).isNotNull();
    }
    @Test
    @Transactional
    void memberFindByIdTest(){
        Member member = new Member();
        memberRepository.save(member);
        memberRepository.flushAndClear();
        Member findMember = memberRepository.findById(member.getId());
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
    }


}