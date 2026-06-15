package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // CREATE — Add a new book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // READ — Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // READ — Get one book by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // UPDATE — Update an existing book
    public Book updateBook(Long id, Book bookDetails) {
        Optional<Book> existingBook = bookRepository.findById(id);
        
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setIsbn(bookDetails.getIsbn());
            book.setPrice(bookDetails.getPrice());
            book.setDescription(bookDetails.getDescription());
            book.setYearPublished(bookDetails.getYearPublished());
            
            return bookRepository.save(book);
        }
        
        return null; // or throw exception
    }

    // DELETE — Delete a book by ID
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}