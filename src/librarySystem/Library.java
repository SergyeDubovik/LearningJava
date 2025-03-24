package librarySystem;

import com.library.PrintedProduction;
import com.library.filter.Filter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Library implements LibraryManagement {
    private Map<Integer, PrintedProduction> books;
    private List<Customer> customers;
    private Map<PrintedProduction, Record> borrowedBooks;
    private static final int LEASE = 30;
    private static final long FINE_VALUE = 25;

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
        LocalDate returnDate = record.getDate().plusDays(LEASE);
        if (currentDate.isAfter(returnDate)) {
            daysDue = ChronoUnit.DAYS.between(returnDate, currentDate);
            countFine = daysDue * FINE_VALUE;
        }
        if (currentDate.isBefore(record.getDate())) {
            throw new IllegalArgumentException("Error: return date should not be earlier than borrow date");
        }
        borrowedBooks.remove(book);
        return countFine;
    }

    public String viewBorrowed() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<PrintedProduction, Record> entry : borrowedBooks.entrySet()) {
            PrintedProduction production = entry.getKey();
            Record rec = entry.getValue();
            sb.append("Production: ")
                    .append(production.getTitle())
                    .append(", ID: ")
                    .append(production.getId())
                    .append(", Borrowed by: ")
                    .append(rec.getCustomer())
                    .append(", Expect return until: ")
                    .append(rec.getDate().plusDays(LEASE));
            if (rec.getDate().plusDays(LEASE).isBefore(LocalDate.now())) {
                sb.append(" !!!");
            }
            sb.append("\n");
        }
        return sb.toString();
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


