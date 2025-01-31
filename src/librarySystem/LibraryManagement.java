package librarySystem;

import com.library.Book;

import java.time.LocalDate;

public interface LibraryManagement {

    void addBook(Book book);

    void registerCustomer(Customer customer);

    Book getBook(LocalDate currentDay, Book book, Customer customer);

    long returnBook(LocalDate currentDay, Book book, Customer customer);


}
