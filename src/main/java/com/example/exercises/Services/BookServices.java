package com.example.exercises.Services;


import com.example.exercises.APIs.ApiException;
import com.example.exercises.Models.Book;
import com.example.exercises.Models.Librarian;
import com.example.exercises.Repos.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServices {

    private final BookRepo bookRepo;


    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public void addBook(Book newBook) {
        bookRepo.save(newBook);
    }


    public void updateBook(Integer id, Book newBook) {
        Book book = bookRepo.findBookById(id);

        if (book != null) {
            book.setAuthor(newBook.getAuthor());
            book.setISBN(newBook.getISBN());
            book.setCategory(newBook.getCategory());
            book.setTitle(newBook.getTitle());
            book.setNumberOfPages(newBook.getNumberOfPages());
            bookRepo.save(book);

        } else
            throw new ApiException("wrong item ID");
    }

    public void deleteBook(Integer id) {
        Book book = bookRepo.findBookById(id);

        if (book != null) {
            bookRepo.delete(book);
        } else
            throw new ApiException("wrong item ID");
    }

    public List<Book> getByCategory(String category) {
        List<Book> books = bookRepo.findBookByCategory(category);

        if (books.isEmpty()) {
            throw new ApiException("there's no item in this category");
        }
        return books;
    }

    public List<Book> getMoreThan300() {
        List<Book> books = bookRepo.findBookByNumberOfPagesGreaterThanEqual();

        if (books.isEmpty()) {
            throw new ApiException("there's no item with page greater than 300");
        }
        return books;
    }

    public List<Book> getByAuthor(String author) {
        List<Book> books = bookRepo.findBookByAuthor(author);

        if (books.isEmpty()) {
            throw new ApiException("there's no item in this author");
        }
        return books;
    }

    public Book getByTitle(String title) {
        Book book = bookRepo.findBookByTitle(title);

        if (book != null)
            return book;
        else
            throw new ApiException("there's no book with this title");

    }


}
