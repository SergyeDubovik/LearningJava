package librarySystem;

import com.library.Book;
import com.library.PrintedProduction;
import com.library.filter.FromYearTillYearFilter;
import com.library.filter.GenreFilter;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.List;

public class RunLibrary {
    public static void main(String[] args) {
        Library library = buildLibrary();
        Customer ted = new Customer("Ted");
        Customer tim = new Customer("Tim");

        library.registerCustomer(ted);
        library.registerCustomer(tim);

        LocalDate borrowDate = LocalDate.of(2025, Month.FEBRUARY, 1);

        Collection<PrintedProduction> books = library.getBooks();
        PrintedProduction pp = books.iterator().next();
        int bookId = pp.getId();
        PrintedProduction borrowedBook = library.borrowPrintedProduction(borrowDate, bookId, ted);
        System.out.println("Ted borrowed: " + borrowedBook);

        LocalDate returnDate = LocalDate.of(2025, Month.MARCH, 22);

        long fine = library.returnBook(returnDate, bookId, ted);
        System.out.println(fine);

        GenreFilter fantasy = new GenreFilter("fantasy");
        List<PrintedProduction> fantasyBooks = library.filter(fantasy);
        List<PrintedProduction> booksByYear = library.filter(new FromYearTillYearFilter(1984, 1999));
        System.out.println(booksByYear);
        System.out.println(fantasyBooks);
    }

    public static Library buildLibrary() {
        Library library = new Library();
        Book book1 = new Book("Dune", 512, 1983, "hung", "Ed Sheeran",
                null, "fantasy");
        Book book2 = new Book("Shining", 433, 1985, "oda", "Steven King",
                null, "Thriller");
        Book book3 = new Book("witcher", 452, 2000, "heaven", "Jean Claude",
                "Dave", "fantasy");
        PrintedProduction pp = new PrintedProduction("truth paper", 23, 1990);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(pp);
        return library;
    }
}
