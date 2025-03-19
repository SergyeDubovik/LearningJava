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
    public PrintedProduction borrowPrintedProduction(LocalDate currentDay, int id, Customer customer) {
        PrintedProduction book = books.get(id);
        if (book != null) {
            borrowedBooks.put(book, new Record(customer, currentDay));
            return book;
        }
        return null;
    }

    @Override
    public long returnBook(LocalDate currentDate, int id, Customer customer) {
        PrintedProduction book = books.get(id);
        long daysDue;
        long countFine = 0;
        Record record = borrowedBooks.get(book);
        if (record == null) {
            throw new IllegalArgumentException("This book is not available");
        }
        if (!customer.equals(record.getCustomer())) {
            throw new IllegalArgumentException("wrong customer");
        }
        LocalDate returnDate = record.getDate().plusDays(lease);
        if (currentDate.isAfter(returnDate)) {
            daysDue = ChronoUnit.DAYS.between(returnDate, currentDate);
            countFine = daysDue * fineValue;
        }
        if (currentDate.isBefore(record.getDate())) {
            throw new IllegalArgumentException("Error: return date should not be earlier then borrow date");
        }
        borrowedBooks.remove(book);
        return countFine;
    }
    public List<PrintedProduction> filter(Filter filter) {
        return filter.filter(new ArrayList<>(books.values()));
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


