package librarySystem;

import com.library.Book;
import com.library.PrintedProduction;
import com.library.filter.FromYearTillYearFilter;
import com.library.filter.GenreFilter;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Scanner;

import static librarySystem.RunLibrary.buildLibrary;

public class LibraryCLI {
    public static void main(String[] args) {

        Library library = buildLibrary();

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to library.");
        boolean exit = false;
        while (!exit) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1 - Show available books");
            System.out.println("2 - Get book");
            System.out.println("3 - Return book");
            System.out.println("0 - Exit");
            System.out.println("Your choice:");

            String input = in.nextLine();

            switch (input) {
                case "1":
                    System.out.println("Available books:");
                    System.out.println("    1 - Show all books");
                    System.out.println("    2 - Filter by Author");
                    System.out.println("    3 - Filter by From year till year");
                    System.out.println("    4 - Filter by Genre");
                    System.out.println("    5 - Filter by Released after ");
                    System.out.println("    0 - Return to previous menu ");
                    String subMenuInput = in.nextLine();
                    switch (subMenuInput) {
                        case "1":
                            for (PrintedProduction production : library.getBooks()) {
                                System.out.println(production);
                            }
                            break;
                        case "0":
                            break;
                        default:
                            System.out.println("Please input correct value");
                            break;
                    }
                    break;
                case "2":
                    System.out.println("Implementation of getting book will be added soon");

                    break;
                case "3":
                    System.out.println("Implementation of returning book will be added soon");

                    break;
                case "0":
                    System.out.println("Thanks for visiting, goodbye for now.");
                    exit = true;
                    break;

                default:
                    System.out.println("Wrong input, try again");
                    break;
            }
        }
    }
}
