package librarySystem;

import com.library.Book;

public class RunLibrary {
    public static void main(String[] args) {

        Library library = new Library();

        Book book1 = new Book("Dune", 512, 1983, "hung", "Ed Sheeran",
                null, "fantasy");
        Book book2 = new Book("Shining", 433, 1985, "oda", "Steven King",
                null, "Thriller");

        Customer customer1 = new Customer("Ted");
        Customer customer2 = new Customer("Tim");

        library.addBook(book1);
        library.addBook(book2);

        library.registerCustomer(customer1);
        library.registerCustomer(customer2);

    }
}
