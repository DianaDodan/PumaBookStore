package com.puma.pumabookstore.dto.transformer;

import com.puma.pumabookstore.domain.Book;
import com.puma.pumabookstore.dto.BookDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class BookTransformer {
    /**
     * transform DTO book into an object
     * @param bookDto bookDTO
     * @return Book transformed book
     */
    public static Book transform(BookDto bookDto) {
        return new Book(bookDto.getAuthor(), bookDto.getTitle());
    }

    public static BookDto transform(Book book) {
        return new BookDto(book.getAuthor(), book.getTitle());
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
