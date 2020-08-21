package com.puma.pumabookstore.repository;

import com.puma.pumabookstore.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    @Query(value = "SELECT * FROM BOOK WHERE AUTHOR = ?1 OR TITLE = ?2", nativeQuery = true)
    public Collection<Book> getBooksByAuthorOrTitle(String author, String title);

    @Query(value = "SELECT * FROM BOOK WHERE AUTHOR = ?1 AND TITLE = ?2", nativeQuery = true)
    public Collection<Book> getBooksByAuthorAndTitle(String author, String title);

}
