package librarySystem;

import com.library.Book;
import com.library.PrintedProduction;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

import static librarySystem.RunLibrary.buildLibrary;

public class LibraryCLI {
    public static void main(String[] args) {

        Library library = buildLibrary();

        Scanner userInput = new Scanner(System.in);

        runMainMenu(userInput, library);
    }

    private static void runMainMenu(Scanner userInput, Library library) {
        boolean exit = false;
        while (!exit) {
            mainMenuDisplay();
            String input = userInput.nextLine();

            switch (input) {
                case "1":
                    subMenuDisplay();
                    runSubMenu(userInput, library);
                    break;

                case "2":
                    lendPrintedProduction(userInput, library);
                    break;

                case "3":
                    returnPrintedProduction(userInput, library);
                    break;

                case "4":
                    booksSortingMenuDisplay();
                    runBooksSortingMenu(userInput, library);
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

    private static void lendPrintedProduction(Scanner userInput, Library library) {
        int bookId;
        System.out.println("Which book do customer want to borrow? Please enter book ID:");
        while (true) {
            bookId = Integer.parseInt(userInput.nextLine());
            if (bookId < 0 || bookId > library.getBooks().size()) {
                System.out.println("There is no book contains this id, input correct id:");
                continue;
            }
            break;
        }

        System.out.println("Please input customer's name:");
        String customerName = userInput.nextLine();
        Customer customer = new Customer(customerName);

        LocalDate localDate = null;
        System.out.println("Please input borrow date (yyyy-mm-dd):");
        while (localDate == null) {
            String borrowDate = userInput.nextLine();
            try {
                localDate = LocalDate.parse(borrowDate);
                PrintedProduction borrowedBook = library.borrowPrintedProduction(localDate, bookId, customer);
                System.out.println(borrowedBook.getTitle() + " (ID " + bookId + ") was taken by " + customerName +
                        " on " + localDate + ", it should be returned on " + localDate.plusDays(30));
            } catch (DateTimeException exception) {
                System.out.println("Please input date in correct format as stated above:");
            }
        }
    }

    private static void returnPrintedProduction(Scanner in, Library library) {
        System.out.println("Which book do customer want to return? Lets check it ID:");
        int bookId;
        while (true) {
            try {
                bookId = Integer.parseInt(in.nextLine());
                if (bookId < 0 || bookId > library.getBooks().size()) {
                    System.out.println("Invalid book ID, please input correct value");
                    continue;
                }
                break;
            } catch (NumberFormatException exception) {
                System.out.println("U have to input numeric value! Do it below:");
            }
        }

        System.out.println("Please input customer's name:");
        String customerName = in.nextLine();
        Customer customer = new Customer(customerName);

        LocalDate localDate;
        System.out.println("Please input return date (yyyy-mm-dd):");
        String currentDate = in.nextLine();
        localDate = LocalDate.parse(currentDate);

        try {
            long fine = library.returnBook(localDate, bookId, customer);
            if (fine > 0) {
                System.out.println("Customer must pay a fine - " + fine + " USD");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("Incorrect input: " + exception.getMessage());
        }
        System.out.println("Thank you for using our service");
    }

    private static void runSubMenu(Scanner in, Library library) {
        boolean backToMainMenu = false;
        while (!backToMainMenu) {
            String subMenuInput = in.nextLine();

            switch (subMenuInput) {
                case "1":
                    for (PrintedProduction production : library.getBooks()) {
                        System.out.println(production);
                    }
                    subMenuDisplay();
                    break;

                case "0":
                    System.out.println("Get back to main menu");
                    backToMainMenu = true;
                    break;

                default:
                    System.out.println("Please input correct value");
                    break;
            }
        }
    }

    private static void runBooksSortingMenu(Scanner input, Library library) {
        boolean backToPreviousMenu = false;
        while (!backToPreviousMenu) {
            String in = input.nextLine();
            switch (in) {
                case "1":
                    List<Map.Entry<PrintedProduction, Record>> borrowedByAuthor =
                            new ArrayList<>(library.getBorrowedBooks().entrySet());
                    borrowedByAuthor.stream()
//                            .filter(entry -> entry.getKey() instanceof Book)
                            .sorted(Comparator.comparing(entry ->
                                    ((Book) entry.getKey()).getAuthor().toLowerCase()))
                            .forEach(entry -> {
                                Book book = (Book) entry.getKey();
                                System.out.println(book.getAuthor() + ", Book: " + book.getTitle());
                            });
                    break;
                case "2":
                    List<Map.Entry<PrintedProduction, Record>> borrowedByTitle =
                            new ArrayList<>(library.getBorrowedBooks().entrySet());
                    borrowedByTitle.stream()
                            .sorted(Comparator.comparing(entry ->
                                    (entry.getKey()).getTitle().toLowerCase()))
                            .forEach(entry -> {
                                PrintedProduction pp = entry.getKey();
                                System.out.println("Sorted borrowed production: " + pp.getTitle());
                            });
                    break;
                case "3":
                    List<Map.Entry<PrintedProduction, Record>> byBorrowDate =
                            new ArrayList<>(library.getBorrowedBooks().entrySet());
                    byBorrowDate.stream()
                            .sorted(Comparator.comparing(entry ->
                                    entry.getValue().borrowDate().plusDays(30)))
                            .forEach(entry -> {
                                PrintedProduction prod = entry.getKey();
                                Record rec = entry.getValue();
                                LocalDate expectedReturnDate = rec.borrowDate().plusDays(30);
                                System.out.println(prod.getTitle() + ", Expected return date: " + expectedReturnDate);
                            });
                    break;
                case "0":
                    backToPreviousMenu = true;
                default:
                    System.out.println("wrong input");
                    break;
            }
        }

    }

    private static void subMenuDisplay() {
        System.out.println();
        System.out.println("Available books:");
        System.out.println("    1 - Show all books");
        System.out.println("    2 - Filter by Author");
        System.out.println("    3 - Filter by From year till year");
        System.out.println("    4 - Filter by Genre");
        System.out.println("    5 - Filter by Released after ");
        System.out.println("    0 - Return to previous menu ");
    }

    private static void mainMenuDisplay() {
        System.out.println();
        System.out.println("Welcome to library.");
        System.out.println("What would you like to do?");
        System.out.println("1 - Show available books");
        System.out.println("2 - Lend book");
        System.out.println("3 - Return book");
        System.out.println("4 - Show Borrowed books");
        System.out.println("0 - Exit");
        System.out.println("Your choice:");
    }

    private static void booksSortingMenuDisplay() {
        System.out.println("1 - by author");
        System.out.println("2 - by book name");
        System.out.println("3 - by expected return date");
        System.out.println("0 - back to previous menu");
    }
}
