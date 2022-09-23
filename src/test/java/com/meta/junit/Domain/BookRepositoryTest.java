package com.meta.junit.Domain;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;



@DataJpaTest
public class BookRepositoryTest {

    Logger log = LoggerFactory.getLogger(BookRepositoryTest.class);
    @Autowired
    private BookRepository bookRepository;

    // 1. 책 등록
    @Test
    public void 책_등록() {
        log.info("책_등록() 테스트");
    }

    // 2. 책 목록보기

    // 3. 책 한건보기

    // 4. 책 수정

    // 5. 책 삭제

}
