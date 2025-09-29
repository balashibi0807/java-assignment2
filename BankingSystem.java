package javaassign2;

import java.util.*;

public class BankingSystem {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, Customer> customers = new HashMap<>();
    static Map<Integer, BankAccount> accounts = new HashMap<>();
    static int accountCounter = 3000;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Banking Management System ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Open Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Apply Loan");
            System.out.println("6. Display Account Details");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addCustomer();
                case 2 -> openAccount();
                case 3 -> depositMoney();
                case 4 -> withdrawMoney();
                case 5 -> applyLoan();
                case 6 -> displayAccountDetails();
                case 7 -> {
                    System.out.println("Exiting system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addCustomer() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        Customer customer = new Customer(name);
        customers.put(customer.getCustomerId(), customer);
        System.out.println("Customer added. ID: " + customer.getCustomerId());
    }

    private static void openAccount() {
        System.out.print("Enter Customer ID: ");
        int cid = sc.nextInt();
        Customer customer = customers.get(cid);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        System.out.print("Enter account type (1-Savings, 2-Current): ");
        int type = sc.nextInt();
        BankAccount account;
        int accNum = ++accountCounter;
        if (type == 1) account = new SavingsAccount(accNum, customer);
        else account = new CurrentAccount(accNum, customer);
        accounts.put(accNum, account);
        System.out.println("Account opened successfully. Account Number: " + accNum);
    }

    private static void depositMoney() {
        System.out.print("Enter Account Number: ");
        int accNum = sc.nextInt();
        BankAccount account = accounts.get(accNum);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        Transaction t = new DepositTransaction(account, amount);
        t.process();
    }

    private static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        int accNum = sc.nextInt();
        BankAccount account = accounts.get(accNum);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        Transaction t = new WithdrawalTransaction(account, amount);
        t.process();
    }

    private static void applyLoan() {
        System.out.print("Enter Customer ID: ");
        int cid = sc.nextInt();
        Customer customer = customers.get(cid);
        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }
        System.out.print("Enter loan amount: ");
        double amount = sc.nextDouble();
        Loan loan = new Loan(customer, amount, accounts);
        loan.displayLoanStatus();
    }

    private static void displayAccountDetails() {
        System.out.print("Enter Account Number: ");
        int accNum = sc.nextInt();
        BankAccount account = accounts.get(accNum);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        account.displayAccountDetails();
    }
}

