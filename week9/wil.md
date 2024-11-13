# Weekly I Learned
## 컨트롤러
- DTO를 사용해 서비스 계층과 소통(서비스 계층에 의존함)
- HTTP GET/POST/PUT/PATCH/DELETE 사용
- 일반적으로 데이터는 body에 담되 요청 데이터는 Request body, 응답 데이터는 Response body에 담음
- 어노테이션 @{HTTP 메서드 이름}Mapping으로 메서드 종류 지정 가능

## DTO
- Data Transfer Object의 약자
-  데이터를 전달하기 위한 자바 객체
-  상황에 따라 Getter/Setter를 사용해줘야 함

## 상태 코드
- 처리 결과를 클라이언트에게 알려줄 때 사용
- ResponseEntity를 통해 http 응답 반환
#### 주요 상태 코드
- 200 ok: 처리 성공
- 201 created: 데이터 생성 성공
- 400 bad request: 클라이언트 요청 오류
- 404 not found: 요청 데이터 없음
- 500 internal server error: 서버 에러