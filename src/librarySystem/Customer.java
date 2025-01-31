package librarySystem;

public class Customer {

    static int idCounter = 1;

    private final String name;
    private final int personalId;

    public Customer(String name) {
        this.name = name;
        personalId = idCounter++;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", personalId=" + personalId +
                '}';
    }
}
