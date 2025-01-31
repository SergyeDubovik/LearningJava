package librarySystem;

import com.library.Book;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library implements LibraryManagement {
    private List<Book> books;
    private List<Customer> customers;
    private Map<Book, Record> borrowedBooks;

    public Library() {
        books = new ArrayList<>();
        customers = new ArrayList<>();
        borrowedBooks = new HashMap<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Book getBook(LocalDate currentDay, Book book, Customer customer) {
        if (books.contains(book)) {
            borrowedBooks.put(book, new Record(customer, currentDay));
            return book;
        } else {
            return null;
        }
    }

    @Override
    public long returnBook(LocalDate currentDay, Book book, Customer customer) {
        long daysDue;
        long countFine = 0;
        Record record = borrowedBooks.get(book);
        if (record == null) {
            throw new RuntimeException("This book is not available");
        }
        LocalDate returnDate = record.getDate().plusDays(30);
        if (currentDay.isAfter(returnDate)) {
            daysDue = ChronoUnit.DAYS.between(returnDate, currentDay);
            long fineValue = 25;
            countFine = daysDue * fineValue;
        }
        return countFine;
    }
}


