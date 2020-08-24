package com.puma.pumabookstore.service;

import com.puma.pumabookstore.domain.Book;
import com.puma.pumabookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Collection<Book> saveBooksInDataBase(Collection<Book> books) {
        return (Collection<Book>) bookRepository.saveAll(books);
    }

    public Collection<Book> getAllBooks() {
        return (Collection<Book>) bookRepository.findAll();
    }

    public Book getBook(int id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public Collection<Book> getBooksFiltered(String author, String title) {
        if (title != null && author != null) {
            return bookRepository.getBooksByAuthorAndTitle(author, title);
        } else {
            return bookRepository.getBooksByAuthorOrTitle(author, title);
        }
    }

    public Collection<Book> getBooksInPriceRange(double minimumPrice, double maximumPrice) {
        return bookRepository.getBooksBetweenPrice(minimumPrice, maximumPrice);
    }
}

