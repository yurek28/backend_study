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
<<<<<<< HEAD
        //member.register(id, password);
=======
        member.register(id, password);
>>>>>>> 74004ae4c9e6d7a00a503d7c5b2654f47bc1147e
        memberRepository.save(member);
    }
}
