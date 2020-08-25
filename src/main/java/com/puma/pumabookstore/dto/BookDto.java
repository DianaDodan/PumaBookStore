package com.puma.pumabookstore.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class BookDto {
    private final String author;
    private final String title;
    private double price;
    private final int pageCount;

    @JsonCreator
    public BookDto(@JsonProperty("author") String author,
                   @JsonProperty("title") String title,
                   @JsonProperty("price") double price,
                   @JsonProperty("pageCount") int pageCount) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getPageCount() {
        return pageCount;
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
