package librarySystem;

import com.library.Book;
import com.library.PrintedProduction;
import com.library.filter.Filter;
import com.library.filter.GenreFilter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Library implements LibraryManagement {
    private Map<Integer, PrintedProduction> books;
    private List<Customer> customers;
    private Map<PrintedProduction, Record> borrowedBooks;
    private static final int lease = 30;
    private static final long fineValue = 25;

    public Library() {
        books = new HashMap<>();
        customers = new ArrayList<>();
        borrowedBooks = new HashMap<>();
    }

    @Override
    public void addBook(PrintedProduction book) {
        books.put(book.getId(), book);
    }

    @Override
    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public PrintedProduction borrowPrintedProduction(LocalDate currentDay, PrintedProduction book, Customer customer) {
        if (books.containsValue(book)) {
            borrowedBooks.put(book, new Record(customer, currentDay));
            return book;
        } else {
            return null;
        }
    }

    @Override
    public long returnBook(LocalDate currentDay, PrintedProduction book, Customer customer) {
        long daysDue;
        long countFine = 0;
        Record record = borrowedBooks.get(book);
        if (record == null) {
            throw new RuntimeException("This book is not available");
        }
        LocalDate returnDate = record.getDate().plusDays(lease);
        if (currentDay.isAfter(returnDate)) {
            daysDue = ChronoUnit.DAYS.between(returnDate, currentDay);
            countFine = daysDue * fineValue;
        }
        return countFine;
    }

    public List<PrintedProduction> filter(Filter filter) {
        PrintedProduction[] filteredBooks = filter.filter(books.values().toArray(new PrintedProduction[0]));
        return Arrays.asList(filteredBooks);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", customers=" + customers +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }

    public Collection<PrintedProduction> getBooks() {
        return books.values();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Map<PrintedProduction, Record> getBorrowedBooks() {
        return borrowedBooks;
    }
}


