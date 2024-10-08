package com.example.todo_api.member_friend;

import com.example.todo_api.friend.Friend;
import com.example.todo_api.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member_Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Member_Friend_Id")
    private Long id;
    @JoinColumn(name = "Member_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
    @JoinColumn(name = "Friend_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Friend friend;
    @Column(name = "Member_Friend_Todo")
    private String todo;

    public Member_Friend(Member member, Friend friend, String todo) {
        this.member = member;
        this.friend = friend;
        this.todo = todo;
    }
}
