package com.example.todo_api.friend;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Friend {
    @Id
    @Column(name = "Friend_Id")
    private Long id;
}
