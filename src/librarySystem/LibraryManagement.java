package librarySystem;

import com.library.PrintedProduction;

import java.time.LocalDate;

public interface LibraryManagement {

    void addBook(PrintedProduction book);

    void registerCustomer(Customer customer);

    PrintedProduction borrowPrintedProduction(LocalDate currentDay, PrintedProduction book, Customer customer);

    long returnBook(LocalDate currentDay, PrintedProduction book, Customer customer);


}
