package com.example.exercises.Services;


import com.example.exercises.APIs.ApiException;
import com.example.exercises.Models.Librarian;
import com.example.exercises.Repos.LibrarianRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LibrarianServices {

    private final LibrarianRepo librarianRepo;

    public List<Librarian> getAllLibrarians() {
        return librarianRepo.findAll();
    }

    public void addLibrarian(Librarian newLibrarian) {
        librarianRepo.save(newLibrarian);
    }


    public void updateLibrarian(Integer id, Librarian newLibrarian) {
        Librarian librarian = librarianRepo.findLibrarianById(id);

        if (librarian != null) {
            librarian.setName(newLibrarian.getName());
            librarian.setEmail(newLibrarian.getEmail());
            librarian.setUsername(newLibrarian.getUsername());
            librarian.setPassword(newLibrarian.getPassword());
            librarianRepo.save(librarian);
        } else
            throw new ApiException("wrong item ID");
    }

    public void deleteLibrarian(Integer id) {
        Librarian lib = librarianRepo.findLibrarianById(id);

        if (lib != null) {
            librarianRepo.delete(lib);
        } else
            throw new ApiException("wrong item ID");


    }

    public Librarian getLibrarianById(Integer id) {
        Librarian librarian = librarianRepo.findLibrarianById(id);

        if (librarian != null)
            return librarian;
        else
            throw new ApiException("wrong ID");
    }

    public Librarian checkLogIn(String username, String password) {
        Librarian user = librarianRepo.checkLogIn(username, password);

        if (user != null)
            return user;
        else
            throw new ApiException("wrong username OR password");
    }

    public Librarian getLibrarianByEmail(String email) {
        Librarian librarian = librarianRepo.findLibrarianByEmail(email);

        if (librarian != null)
            return librarian;
        else
            throw new ApiException("wrong email");
    }

}
