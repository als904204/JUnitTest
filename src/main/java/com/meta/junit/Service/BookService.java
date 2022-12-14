package com.meta.junit.Service;

import com.meta.junit.Domain.Book;
import com.meta.junit.Domain.BookRepository;
import com.meta.junit.Util.MailSender;
import com.meta.junit.Web.Dto.BookResponseDto;
import com.meta.junit.Web.Dto.BookSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    private final MailSender mailSender;


    // 1. 책 등록
    @Transactional(rollbackFor = RuntimeException.class)
    public BookResponseDto 책_등록(BookSaveRequestDto dto) {
        // 만약 Book 엔티티를 리턴해 버릴경우
        // 영속화된 Book 클래스가 참조하는 다른 클래스까지 리턴하기 때문에
        // 따로 응답Dto 를 생성하여 리턴
        Book bookPS = bookRepository.save(dto.toEntity());
        sendEmailFailed(bookPS);
        return new BookResponseDto().toDto(bookPS);
    }

    private void sendEmailFailed(Book bookPS) {
        if (bookPS != null) {
            if (!mailSender.send()) {
                throw new RuntimeException("메일이 전송되지 않았습니다");
            }
        }
    }

    // 2. 책 목록 조회
    public List<BookResponseDto> 책_목록_조회() {
        List<Book> all = bookRepository.findAll();

        return bookRepository.findAll().stream()
                .map(new BookResponseDto()::toDto) // 왼쪽 객체의 오른쪽 메소드 사용
                .collect(Collectors.toList());
    }

    // 3. 책 한권 조회
    public BookResponseDto 책_조회(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Exists the book : " + id));
        return new BookResponseDto().toDto(book);
    }


    // 4. 책 삭제
    @Transactional(rollbackFor = RuntimeException.class)
    public void 책_삭제(Long id) {
       bookRepository.deleteById(id);
    }

    // 5. 책 수정
    @Transactional(rollbackFor = RuntimeException.class)
    public void 책_수정(Long id, BookResponseDto dto) {

        Book book = bookRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Not Exists the book :  + id)")
        );



        book.update(dto.getTitle(), dto.getAuthor());

    }
}
