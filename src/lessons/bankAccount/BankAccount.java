package lessons.bankAccount;

// https://drive.google.com/file/d/1HzvVjAUeSr7K3n1BBA6xvKU7OC6slH9O/view?usp=drive_link

public class BankAccount {
    private double balance;
    private double minBalance;

    public BankAccount(double balance, double minBalance) {
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public double withdraw(double amount) {
        if (balance - amount > minBalance) {
            balance -= amount;
            return amount;
        } else {
            throw new RuntimeException();
        }
    }

    public double deposit(double amount) {
        return balance += amount;
    }
}
