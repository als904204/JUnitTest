# 테스트 순서
1. Repository
    - DB쪽 관련 테스트
2. Service
    - 로직 트랜잭션 테스트
3. Controller
    - 클라이언트와 테스트

## 1. RepositoryTest
- @DataJpaTest : 부분 테스트를 위한 어노테이션 (DB에 관한 클래스만 띄움)
