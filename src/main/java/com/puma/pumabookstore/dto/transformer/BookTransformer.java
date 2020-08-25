package com.puma.pumabookstore.dto.transformer;

import com.puma.pumabookstore.domain.Book;
import com.puma.pumabookstore.dto.BookDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class BookTransformer {
    public static Book transform(BookDto bookDto) {
        return new Book(bookDto.getAuthor(), bookDto.getTitle(), bookDto.getPrice(), bookDto.getPageCount());
    }

    public static BookDto transform(Book book) {
        return new BookDto(book.getAuthor(), book.getTitle(), book.getPrice(), book.getPageCount());
    }

    public static Collection<Book> transform(Collection<BookDto> bookDtos) {
        //get every dto from the collection, transform into book and add it to the collection of books
        Collection<Book> bookCollection = new ArrayList<>();
        for (BookDto bookDto : bookDtos) {
            Book transformedBook = transform(bookDto);
            bookCollection.add(transformedBook);
        }
        return bookCollection;
    }
}
