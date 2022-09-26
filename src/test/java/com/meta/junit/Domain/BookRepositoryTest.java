package com.meta.junit.Domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@DataJpaTest
public class BookRepositoryTest {

    Logger log = LoggerFactory.getLogger(BookRepositoryTest.class);

    @Autowired
    private BookRepository bookRepository;

    //@BeforeAll // 테스트 시작전 한번만 실행
    @BeforeEach
    public void 책_데이터_생성() {
        log.info("책_데이터_생성()");
        String title = "junit";
        String author = "kmw";

        Book book = Book.builder()
                .title(title)
                .author(author)
                .build();
        bookRepository.save(book);
    }

    /***
     * 트랜잭션 종료 후 자동 초기화
     */


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

    // 2. 책 목록조회
    @Test
    public void 책_목록_조회() {

        // given (데이터 준비)
        String title = "junit";
        String author = "kmw";


        // when
        List<Book> books = bookRepository.findAll();
        log.info("책_목록_조회_size()={}",books.size());

        // then
        assertEquals(title,books.get(0).getTitle());
        assertEquals(author,books.get(0).getAuthor());


        assertNotEquals("differentTitle",books.get(0).getTitle());
        assertNotEquals("differentAuthor",books.get(0).getAuthor());
    }


    // 3. 책 한건 조회
    @Test
    public void 책_한건_조회() {
        // given (데이터 준비)
        String title = "junit";
        String author = "kmw";

        // when
        Book bookPS = bookRepository.findById(1L).get();

        // then
        assertEquals(title, bookPS.getTitle());
        assertEquals(author, bookPS.getAuthor());

    }

    // 4. 책 수정

    // 5. 책 삭제
    @Test
    public void 책_삭제() {
        log.info("책_삭제()");

        // given
        Long id = 1L;

        // when
        bookRepository.deleteById(id);

        // then
        Optional<Book> bookPS = bookRepository.findById(1L);

        if (bookPS.isPresent()) {

        } else {

        }
    }

}
