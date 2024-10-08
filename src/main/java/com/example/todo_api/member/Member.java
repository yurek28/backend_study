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
    @Column(name =  "Member_Login_Id", columnDefinition = "varchar(20)")
    private String Member_Login_Id;
    @Column(name =  "Member_Password", columnDefinition = "varchar(20)")
    private String Member_Password;

}
