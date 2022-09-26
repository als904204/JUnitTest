package com.meta.junit.Web.Dto;


import com.meta.junit.Domain.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookSaveRequestDto {
    private String title;
    private String author;

    public Book toEntity() {
        return Book.builder()
                .title(title)
                .author(author)
                .build();
    }

}
