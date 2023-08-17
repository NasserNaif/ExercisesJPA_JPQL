package com.example.exercises.Repos;


import com.example.exercises.Models.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrarianRepo extends JpaRepository<Librarian, Integer> {
    Librarian findLibrarianById(Integer id);

    Librarian findLibrarianByEmail(String email);

    @Query("select c from Librarian c where c.username=?1 and c.password=?2")
    Librarian checkLogIn(String username, String password);

}
