package javaassign2;

public abstract class BankAccount {
    protected int accountNumber;
    protected double balance;
    protected Customer customer;

    public BankAccount(int accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0.0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Balance: " + balance);
    }
}
