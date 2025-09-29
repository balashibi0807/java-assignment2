package javaassign2;

import java.util.List;
import java.util.Map;

public class Loan {
    private static int loanCounter = 2000;
    private int loanId;
    private Customer customer;
    private double amount;
    private boolean approved;

    public Loan(Customer customer, double amount, Map<Integer, BankAccount> accounts) {
        this.customer = customer;
        this.amount = amount;
        this.loanId = ++loanCounter;
        this.approved = checkEligibility(accounts);
    }

    private boolean checkEligibility(Map<Integer, BankAccount> accounts) {
        // Simple eligibility: Customer must have at least 1000 in any account
        return accounts.values().stream()
                .filter(acc -> acc.getCustomer().getCustomerId() == customer.getCustomerId())
                .anyMatch(acc -> acc.getBalance() >= 1000);
    }

    public void displayLoanStatus() {
        System.out.println("Loan ID: " + loanId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Loan Amount: " + amount);
        if (approved) System.out.println("Loan Status: Approved");
        else System.out.println("Loan Status: Rejected (Eligibility criteria not met)");
    }
}
