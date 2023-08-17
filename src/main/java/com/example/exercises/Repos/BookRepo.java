package com.example.exercises.Repos;


import com.example.exercises.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    List<Book> findBookByCategory(String category);


    @Query("select c from Book c where c.numberOfPages >= 300")
    List<Book> findBookByNumberOfPagesGreaterThanEqual();

    List<Book> findBookByAuthor(String author);

    Book findBookByTitle(String title);

    Book findBookById(Integer id);

}
