<!-- 프로젝트 이름 -->
PROJECT
===
:large_blue_diamond: 개요
---
<!-- 프로젝트의 목표가 무엇인가 -->

일정을 관리하는 웹 서버 프로젝트 작성

<!-- 무엇을 구현하였는가 --><br>

**개발 환경**
JDK: Oracle JDK 17.0.14
<br>
IDE: IntelliJ
<br>
Framework: Spring

- - -
## :large_blue_diamond: 요구사항
공통 조건
1. 모든 테이블은 id를 가진다
2. 3 Layer Architecture 에 따라 개발 controller service repository
3. CRUD는 JPA사용
4. 인증 인가 Cookie Session 활용
5. JPA 연관 관계는 단 방향 / 정말 필요할 때만 양방향 적용
    - 각 Entity 간의 연관관계 설정
    - DB에서 join과 같은 개념
    - 단 DB에서는 단 방향, 양 방향과 같은 개념이 존재하지 않으며 java 객체 (Entity) 기준

Lv 0
1. API 명세서 작성성
   - 프로젝트 최상위 경로의 README에 작성
2. ERD 작성
    - 프로젝트 최상위 경로의 README에 작성
3. SQL 작성
    - 프로젝트 최상위 경로에 schedule.sql 파일을 생성
    - 테이블 생성에 필요한 쿼리 작성

Lv 1
1. 일정 CRUD
   - 일정을 CRUD 할 수 있다. 
   - 필드 값 : id, 작성 유저명, 제목, 내용, 작성일, 수정일
     - 작성일, 수정일은 JPA Auditing 사용

Lv 2
1. 유저 CRUD
   - 유저를 CRUD 할 수 있다.
   - 필드 값 :  id, 유저명, 이메일, 작성일, 수정일
     - 작성일, 수정일은 JPA Auditing 사용
2. 연관 관계 구현
   - 일정 필드 값 : 작성 유저명 → 유저 고유 식별자 (유저 id)

Lv 3
1. 회원가입
   - 유저 필드 값 : 비밀번호 추가

Lv 4
1. 로그인 (인증)
   - 설명
     - Cookie/Session을 활용해 로그인 기능을 구현
     - @Configuration 을 활용해 필터 등록 & 필터를 활용하여 인증 처리
   - 조건
     - 이메일과 비밀번호로 로그인 기능 구현
     - 회원가입, 로그인 요청은 인증에서 제외
   - 예외 처리
     - 로그인 시 이메일과 비밀번호가 일치하지 않다면 HTTP Status code 401 반환

- - -
## :large_blue_diamond: API 명세서 & ERD 작성

### API 명세서 
![https://hushed-ox-d32.notion.site/API-1c329343d97880eca646ccb052c40a70?pvs=4](https://hushed-ox-d32.notion.site/image/attachment%3Ae4a09ba2-ce00-4b60-abb7-d4a4f5f46156%3A1.png?table=block&id=1cb29343-d978-8083-a8b1-e7745a09b5cd&spaceId=234c0de8-f981-4889-9307-1dd0a0805892&width=1420&userId=&cache=v2)

![https://hushed-ox-d32.notion.site/API-1c329343d97880eca646ccb052c40a70?pvs=4](https://hushed-ox-d32.notion.site/image/attachment%3A56845ff3-a3a7-4914-8d42-8aacd560c23e%3A2.png?table=block&id=1cb29343-d978-80a0-ac55-e2c1147b1c8a&spaceId=234c0de8-f981-4889-9307-1dd0a0805892&width=1420&userId=&cache=v2)

### ERD
![https://hushed-ox-d32.notion.site/ERD-1c329343d978804a9e68c39ab56c4a7c?pvs=4](https://hushed-ox-d32.notion.site/image/attachment%3Ae1dfd590-706d-4b22-a6dd-d92655bc0897%3ABlank_diagram.png?table=block&id=1cb29343-d978-80d6-90d7-d334bb2c2334&spaceId=234c0de8-f981-4889-9307-1dd0a0805892&width=1420&userId=&cache=v2)

### [:memo: 레벨 별 API 명세서 노션 링크](https://hushed-ox-d32.notion.site/API-1c329343d97880eca646ccb052c40a70?pvs=4)

### [:memo: 레벨 별 ERD 노션 링크](https://hushed-ox-d32.notion.site/ERD-1c329343d978804a9e68c39ab56c4a7c?pvs=4)

- - -
## :large_blue_diamond: 구현된 기능
일정 CRUD
1. 작성자, 제목, 내용을 입력하면 일정을 생성한다.
   - id는 auto incredment로 생성한다.
   - 작성일, 수정일은 JPA Auditing을 사용한다.
   - 등록정보를 출력한다.
   - 로그인 구현 후에 로그인 id를 가져와서 userId에 입력한다
2. id를 입력하면 id에 맞는 일정을 선택하여 조회한다.
   - id를 제외하고 출력한다.
   - 로그인 구현 후에 userId에 맞는 table의 name을 가져와서 함께 출력한다.
3. id를 입력하면 id에 맞는 일정을 선택하고 작성자, 제목, 내용을 수정한다.
   - 수정 후 id를 제외하고 출력한다.
   - 로그인 구현 후에 userId에 맞는 table의 name을 가져와서 함께 출력한다.
4. id를 입력하면 id에 맞는 일정을 선택하여 삭제한다.
   
유저 CRUD
1. 유저명, 이메일, 작성일, 수정일을 입력하면 유저를 생성한다.
   - id는 auto incredment로 생성한다.
   - 작성일, 수정일은 JPA Auditing을 사용한다.
   - 등록정보를 출력한다.
2. id를 입력하면 id에 맞는 유저를 선택하여 조회한다.
   - id를 제외하고 출력한다.
3. id를 입력하면 id에 맞는 유저를 선택하고 작성자, 이메일을 수정한다.
   -  수정 후 id를 제외하고 출력한다.
4. id를 입력하면 id에 맞는 유저를 선택하여 삭제한다.
5. 비밀번호 필드를 추가한다.

로그인(인증)
1. email과 password를 확인 후에 Cookie/Session을 사용하여 사용하여 서버와의 로그인을 구현한다.
2. whiteList와 doFilter를 사용하여 요청을 가로채고 구분하여 로그인 체크와 유무를 확인한다.
   - 로그인이 필요하지 않은 요청은 넘기고 그 외 요청은 로그인이 아니라면 로그인을 요청한다.
3. @Configuration을 활용하여 Filter를 등록한다.

- - -
## :large_blue_diamond: 미구현 기능
로그인 유저를 Entity 그대로 사용중이다
- dto를 만들 생각을 못해서 아직 구현이 안되었다.

email을 ID로 사용하기 위해 중복이 될 수 없게 하였다.
- 중복이 되었을 때의 예외처리가 구현되지 않았다.

작성일, 생성일의 가시성을 위해 형식을 변경하지 못 하였다.

- - -
### :large_blue_diamond: TroubleShouting

### [:memo: TroubleShouting](https://deabaind.tistory.com/37)
