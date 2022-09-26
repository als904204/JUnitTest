package com.meta.junit.Service;

import com.meta.junit.Domain.BookRepository;
import com.meta.junit.Util.MailSenderStub;
import com.meta.junit.Web.Dto.BookResponseDto;
import com.meta.junit.Web.Dto.BookSaveRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
public class BookServiceTest {


    @Autowired
    BookRepository bookRepository;

    // Service 를 테스트 하려는데 Repository 객체를 new 해야 함
    // 이를 해결하기 위해 Mockito 라이브러리 사용해야 됨
    @Test
    public void 책_등록() {

        // given
        BookSaveRequestDto dto = new BookSaveRequestDto();
        dto.setTitle("junit");
        dto.setAuthor("kmw");

        // stub 가짜
        MailSenderStub mailSenderStub = new MailSenderStub();

        // when
        BookService bookService = new BookService(bookRepository, mailSenderStub);
        BookResponseDto bookResponseDto = bookService.책_등록(dto);

        // then
        assertEquals(dto.getTitle(),bookResponseDto.getTitle());
        assertEquals(dto.getAuthor(),bookResponseDto.getAuthor());


    }

}
