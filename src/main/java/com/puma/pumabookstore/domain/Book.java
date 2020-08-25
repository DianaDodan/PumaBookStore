package com.puma.pumabookstore.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String author;
    private String title;
    private double price;
    private int pageCount;

    public Book(String author, String title, double price, int pageCount) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.pageCount = pageCount;
    }

    public Book() {
    }

    public int getId() {
        return id;
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

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Double.compare(book.price, price) == 0 &&
                pageCount == book.pageCount &&
                Objects.equals(author, book.author) &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, price, pageCount);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", totalPages=" + pageCount +
                '}';
    }
}