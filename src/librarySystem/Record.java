package librarySystem;

import java.time.LocalDate;

public class Record {
    private Customer customer;
    private LocalDate date;

    public Record(Customer customer, LocalDate date) {
        this.customer = customer;
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getDate() {
        return date;
    }
}
