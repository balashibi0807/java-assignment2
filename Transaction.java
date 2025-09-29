package javaassign2;

import java.util.Date;

public abstract class Transaction {
    protected BankAccount account;
    protected double amount;
    protected Date date;

    public Transaction(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
        this.date = new Date();
    }

    public abstract void process();
}
