package com.example.exercises.Controllers;


import com.example.exercises.APIs.ApiResponse;
import com.example.exercises.Models.Book;
import com.example.exercises.Models.Librarian;
import com.example.exercises.Services.LibrarianServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/librarian")
@RequiredArgsConstructor
public class LibrarianController {
    private final LibrarianServices librarianServices;

    @GetMapping("/get")
    public ResponseEntity getAllBooks() {
        return ResponseEntity.status(200).body(librarianServices.getAllLibrarians());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Librarian lib) {
        librarianServices.addLibrarian(lib);
        return ResponseEntity.status(201).body(new ApiResponse("librarian added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid Librarian lib) {
        librarianServices.updateLibrarian(id, lib);
        return ResponseEntity.status(201).body(new ApiResponse("librarian updated"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        librarianServices.deleteLibrarian(id);
        return ResponseEntity.status(201).body(new ApiResponse("librarian deleted"));
    }


    @GetMapping("/get/{id}")
    public ResponseEntity getByID(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(librarianServices.getLibrarianById(id));
    }


    @GetMapping("/login/{username}/{password}")
    public ResponseEntity logIn(@PathVariable String username, @PathVariable String password) {
        return ResponseEntity.status(200).body(librarianServices.checkLogIn(username, password));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity email(@PathVariable String email) {
        return ResponseEntity.status(200).body(librarianServices.getLibrarianByEmail(email));
    }
}
