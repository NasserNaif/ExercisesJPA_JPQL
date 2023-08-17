package com.example.exercises.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Librarian")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotEmpty(message = "username must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String username;


    @NotEmpty(message = "password must not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9]{7,20}", message = "password is too weak ")
    @Column(columnDefinition = "varchar(20) not null check(password >=7)")
    private String password;


    @NotEmpty(message = "email must not be empty")
    @Column(columnDefinition = "varchar(20) not null unique")
    @Email(message = "email must be valid email")
    private String email;
}
