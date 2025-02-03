package librarySystem;

import com.library.Book;
import com.library.PrintedProduction;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class RunLibrary {
    public static void main(String[] args) {

        Library library = new Library();

        Book book1 = new Book("Dune", 512, 1983, "hung", "Ed Sheeran",
                null, "fantasy");
        Book book2 = new Book("Shining", 433, 1985, "oda", "Steven King",
                null, "Thriller");
        Book book3 = new Book("witcher", 452, 2000, "heaven", "Jean Claude",
                "Dave", "fantasy");

        Customer ted = new Customer("Ted");
        Customer tim = new Customer("Tim");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.registerCustomer(ted);
        library.registerCustomer(tim);

        LocalDate borrowDate = LocalDate.of(2025, Month.FEBRUARY, 1);

        Book borrowedBook = library.getBook(borrowDate, book1, ted);
        System.out.println("Ted borrowed: " + borrowedBook);

        LocalDate returnDate = LocalDate.of(2025, Month.MARCH, 22);

        long fine = library.returnBook(returnDate, book1, ted);
        System.out.println(fine);

        List<PrintedProduction> fantasyBooks = library.genreFilter("fantasy");
        System.out.println(fantasyBooks);

    }
}
