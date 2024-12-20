package com.example.todo_api.friend;

import com.example.todo_api.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Friend {

    @Id
<<<<<<< HEAD
    @Getter
=======
>>>>>>> 74004ae4c9e6d7a00a503d7c5b2654f47bc1147e
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member1")
    private Member member1;

    @ManyToOne
    @JoinColumn(name = "member2")
    private Member member2;

    public Friend(Member member1, Member member2) {
        this.member1 = member1;
        this.member2 = member2;
    }
}