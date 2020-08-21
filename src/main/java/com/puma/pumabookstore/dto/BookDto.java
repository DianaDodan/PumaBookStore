package com.puma.pumabookstore.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class BookDto {
    private final String author;
    private final String title;

    @JsonCreator
    public BookDto(@JsonProperty("author") String author,
                   @JsonProperty("title") String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(author, bookDto.author) &&
                Objects.equals(title, bookDto.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
