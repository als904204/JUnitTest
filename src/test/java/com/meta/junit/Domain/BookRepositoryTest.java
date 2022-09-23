package com.meta.junit.Domain;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
public class BookRepositoryTest {

    Logger log = LoggerFactory.getLogger(BookRepositoryTest.class);
    @Autowired
    private BookRepository bookRepository;

    // 1. 책 등록
    @Test
    public void 책_등록() {
        log.info("책_등록() 테스트 실행");
        // given (데이터 준비)
        String title = "junit5";
        String author = "als";

        Book book = Book.builder()
                .title(title)
                .author(author)
                .build();

        // when  (테스트 실행)
        Book bookPS = bookRepository.save(book);


        // then  (테스트 검증) 기대 값 / 실제 값
        assertEquals(title, bookPS.getTitle());
        assertEquals(author, bookPS.getAuthor());

    }

    // 2. 책 목록보기

    // 3. 책 한건보기

    // 4. 책 수정

    // 5. 책 삭제

}
