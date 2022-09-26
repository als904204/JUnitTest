# 테스트 순서
1. Repository
    - DB쪽 관련 테스트
2. Service
    - 로직 트랜잭션 테스트
3. Controller
    - 클라이언트와 테스트

## 1. RepositoryTest
- @DataJpaTest : 부분 테스트를 위한 어노테이션 (DB에 관한 클래스만 띄움)



# 테스트 메서드 실행
- primary key auto_increment 값 초기화 안됨  (@Sql 이용해 해결)
- >  @Sql("classpath:db/tableInit.sql") 
  > 메서드 실행마다 해당 경로에있는 sql 파일 sql 문 실행