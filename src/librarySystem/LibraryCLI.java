package librarySystem;

import com.library.Book;
import com.library.PrintedProduction;
import com.library.filter.FromYearTillYearFilter;
import com.library.filter.GenreFilter;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Scanner;

public class LibraryCLI {
    public static void main(String[] args) {

        Library library = new Library();
        Book book1 = new Book("Dune", 512, 1983, "hung", "Ed Sheeran",
                null, "fantasy");
        Book book2 = new Book("Shining", 433, 1985, "oda", "Steven King",
                null, "Thriller");
        Book book3 = new Book("witcher", 452, 2000, "heaven", "Jean Claude",
                "Dave", "fantasy");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to library.");
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1 - Show available books");
            System.out.println("2 - Get book");
            System.out.println("3 - Return book");
            System.out.println("4 - Exit");
            System.out.println("Your choice:");

            String input = in.nextLine();

            if (input.equals("1")) {
                for (PrintedProduction production : library.getBooks()) {
                    System.out.println(production);
                }
            } else if (input.equals("2")) {
                System.out.println("Implementation of getting book will be added soon");

            } else if (input.equals("3")) {
                System.out.println("Implementation of returning book will be added soon");

            } else if (input.equals("4")) {
                System.out.println("Thanks for visiting, goodbye for now.");
                break;

            } else {
                System.out.println("Wrong input, try again");
            }
        }
        in.close();


        Customer ted = new Customer("Ted");
        Customer tim = new Customer("Tim");

        library.registerCustomer(ted);
        library.registerCustomer(tim);

        LocalDate borrowDate = LocalDate.of(2025, Month.FEBRUARY, 1);

        Book borrowedBook = library.getBook(borrowDate, book1, ted);
        System.out.println("Ted borrowed: " + borrowedBook);

        LocalDate returnDate = LocalDate.of(2025, Month.MARCH, 22);

        long fine = library.returnBook(returnDate, book1, ted);
        System.out.println(fine);

        GenreFilter fantasy = new GenreFilter("fantasy");
        List<PrintedProduction> fantasyBooks = library.filter(fantasy);
        List<PrintedProduction> booksByYear = library.filter(new FromYearTillYearFilter(1984, 1999));
        System.out.println(booksByYear);

    }
}
