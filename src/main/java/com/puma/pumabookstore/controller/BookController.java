package com.puma.pumabookstore.controller;

import com.puma.pumabookstore.domain.Book;
import com.puma.pumabookstore.dto.BookDto;
import com.puma.pumabookstore.dto.transformer.BookTransformer;
import com.puma.pumabookstore.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {
    BookService bookService;

    public BookController(BookService bookService) {
       this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<Collection<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<Collection<Book>> addBooks(@RequestBody Collection<BookDto> bookDtos) {
        return ResponseEntity.ok(bookService.saveBooksInDataBase((BookTransformer.transform(bookDtos))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @GetMapping("/search")
    public ResponseEntity<Collection<Book>> filterByAuthorOrTitle(@RequestParam(value = "author", required = false) String author,
                                                                  @RequestParam(value = "title", required = false) String title) {
        return ResponseEntity.ok(bookService.getBooksFiltered(author, title));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("The book has been successfully deleted.");
    }
}