package com.example.todo_api.todo;

import com.example.todo_api.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Todo_Id")
    private Long id;
    @Column(name =  "Todo_Content", columnDefinition = "varchar(200)")
    private String content;
    @Column(name = "Todo_Is_Checked", columnDefinition = "tinyint(1)")
    private boolean isChecked = false;
    @JoinColumn(name = "Member_Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public Todo(String content, Member member) {
        this.content = content;
        this.member = member;
    }
    public void updateContent(String content){
        this.content = content;
    }
    public void check() {
        this.isChecked = true;
    }

    public void uncheck() {
        this.isChecked = false;
    }
}
