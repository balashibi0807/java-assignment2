package javaassign2;

public class DepositTransaction extends Transaction {
    public DepositTransaction(BankAccount account, double amount) {
        super(account, amount);
    }

    @Override
    public void process() {
        account.deposit(amount);
        System.out.println("Deposit Transaction successful on " + date);
    }
}
