package com.example.todo_api.friend;

import com.example.todo_api.member.Member;
import com.example.todo_api.member.MemberRepository;
import com.example.todo_api.todo.Todo;
import com.example.todo_api.todo.TodoRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@NoArgsConstructor
public class FriendService {
    private TodoRepository todoRepository;
    private MemberRepository memberRepository;
    private FriendRepository friendRepository;
    @Transactional
    public Friend requestFriend(Long memberId1, Long memberId2){
        Member member1 = memberRepository.findById(memberId1);
        Member member2 = memberRepository.findById(memberId2);
        Friend friend = new Friend(member1, member2);
        friendRepository.save(friend);
        return friend;
    }
    @Transactional
    public void acceptFriend(Long memberId1, Long memberId2){
        Member member1 = memberRepository.findById(memberId1);
        Member member2 = memberRepository.findById(memberId2);
        Friend friend = new Friend(member1, member2);
        friendRepository.save(friend);
    }
    @Transactional
    public List <Friend> viewFriend(Long memberId){
        Member member = memberRepository.findById(memberId);
        return friendRepository.findByMember(member);
    }
    @Transactional
    public void deleteFriend(Friend friend){
        friendRepository.delete(friend);
    }
    @Transactional
    public List<Todo> viewFreindTodo(Long memberId){
        Member member = memberRepository.findById(memberId);
        return todoRepository.findAllByMember(member);
    }
}
