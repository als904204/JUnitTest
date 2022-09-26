package com.meta.junit.Web.Dto;

import com.meta.junit.Domain.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BookResponseDto {
    private Long id;
    private String title;
    private String author;

    public BookResponseDto toDto(Book bookPS) {
        this.id = bookPS.getId();
        this.title = bookPS.getTitle();
        this.author = bookPS.getAuthor();
        return this;
    }



}
