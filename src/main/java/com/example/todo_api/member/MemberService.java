package com.example.todo_api.member;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    @Transactional
    public void register(String id, String password){
        Member member = new Member();
        member.register(id, password);
        memberRepository.save(member);
    }
}
