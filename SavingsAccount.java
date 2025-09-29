package javaassign2;

public class SavingsAccount extends BankAccount {
    private static final double MIN_BALANCE = 500;

    public SavingsAccount(int accountNumber, Customer customer) {
        super(accountNumber, customer);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("Updated Balance: " + balance);
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Updated Balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient balance! Minimum balance: " + MIN_BALANCE);
            return false;
        }
    }
}
