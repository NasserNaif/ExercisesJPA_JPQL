package com.example.exercises.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;

    @NotEmpty(message = "author must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String author;

    @NotEmpty(message = "category must not be empty")
    @Pattern(regexp = "(academic|mystery|novel)")
    @Column(columnDefinition = "varchar(20) not null check(category = 'academic' or category = 'mystery' or category = 'novel')")
    private String category;

    @NotNull(message = "ISBN must not be null")
    @Column(columnDefinition = "integer not null")
    private Integer ISBN;


    @NotNull(message = "number of pages must not be null")
    @Min(value = 50, message = "book must be more than 50 pages")
    @Column(columnDefinition = "integer not null")
    private Integer numberOfPages;
}
