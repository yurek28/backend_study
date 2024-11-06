package com.example.todo_api.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
    @PersistenceContext
    EntityManager em;
    public void save(Member member){
        em.persist(member);
    }
    public Member findById(Long id){
        return em.find(Member.class, id);
    }
    public void flushAndClear(){
        em.flush();
        em.clear();
    }
}
