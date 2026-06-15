package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // JpaRepository gives us all CRUD operations automatically:
    // - save(Book) — CREATE
    // - findById(Long) — READ one
    // - findAll() — READ all
    // - delete(Book) — DELETE
    // - We can add custom queries here if needed
}