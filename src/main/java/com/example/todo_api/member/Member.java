package com.example.todo_api.member;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Member_Id")
    private Long id;
    @Column(name = "Member_Login_Id", columnDefinition = "varchar(20)")
    private String memberId;
    @Column(name = "Member_Password", columnDefinition = "varchar(20)")
    private String memberPassword;

    public void register(String id, String password) {
        this.memberId = id;
        this.memberPassword = password;
    }
    public boolean logIn(String id, String password) {
        if (this.memberId.equals(id) && this.memberPassword.equals(password)) {
            return true;
        }
        return false;
    }

    public Long getId() {
        return id;
    }
}
