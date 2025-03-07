package librarySystem;

import com.library.PrintedProduction;

import java.time.LocalDate;

public interface LibraryManagement {

    void addBook(PrintedProduction book);

    void registerCustomer(Customer customer);

    PrintedProduction borrowPrintedProduction(LocalDate currentDay, int id, Customer customer);

    long returnBook(LocalDate currentDay, int id, Customer customer);


}
