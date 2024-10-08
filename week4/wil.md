# Weekly I Learned

## DB 설계
- 개체(엔티티): 문제 상황을 구성하는 요소
- 관계: 개체와 개체 사이의 관계

개체와 관계로 표현하는 방법을 ER Model (Entity-Relationship Model), ER Model을 다이어그램으로 표현한 것이 ERD

개체와 관계 모두 속성(attribute)을 가질 수 있고 하나의 개체를 식별할 수 있는 속성을 PK(Primary Key) 라고 함

개체와 개체 사이의 4가지 관계
- 다대일 (N : 1)
- 일대다 (1 : N)
- 일대일 (1 : 1)
- 다대다 (N : M)

## JPA  
Java Persistence API

엔티티 클래스를 작성하면 JPA가 자동으로 테이블을 생성하는 SQL을 작성해고 실행해줌

@Entity, @Id 등의 어노테이션을 사용해 매핑


## ERD 이미지
![test](https://github.com/yurek28/backend_study/blob/main/week4/erd.png?raw=true)
