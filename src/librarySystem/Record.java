package librarySystem;

import java.time.LocalDate;

public class Record {
    private final Customer customer;
    private final LocalDate borrowDate;

    public Record(Customer customer, LocalDate date) {
        this.customer = customer;
        this.borrowDate = date;
    }

    @Override
    public String toString() {
        return "customer: " + customer +
                ", date: " + borrowDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }
}
