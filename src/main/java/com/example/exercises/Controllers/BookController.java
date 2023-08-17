package com.example.exercises.Controllers;


import com.example.exercises.APIs.ApiResponse;
import com.example.exercises.Models.Book;
import com.example.exercises.Services.BookServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookServices bookServices;

    @GetMapping("/get")
    public ResponseEntity getAllBooks() {
        return ResponseEntity.status(200).body(bookServices.getAllBooks());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Book book) {
        bookServices.addBook(book);
        return ResponseEntity.status(201).body(new ApiResponse("book added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid Book book) {
        bookServices.updateBook(id, book);
        return ResponseEntity.status(201).body(new ApiResponse("book updated"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        bookServices.deleteBook(id);
        return ResponseEntity.status(201).body(new ApiResponse("book deleted"));
    }


    @GetMapping("/author/{auth}")
    public ResponseEntity author(@PathVariable String auth) {
        return ResponseEntity.status(201).body(bookServices.getByAuthor(auth));
    }

    @GetMapping("/category/{cat}")
    public ResponseEntity category(@PathVariable String cat) {
        return ResponseEntity.status(201).body(bookServices.getByCategory(cat));
    }

    @GetMapping("/search/{title}")
    public ResponseEntity title(@PathVariable String title) {
        return ResponseEntity.status(201).body(bookServices.getByTitle(title));
    }

    @GetMapping("/more300")
    public ResponseEntity more300() {
        return ResponseEntity.status(201).body(bookServices.getMoreThan300());
    }
}
