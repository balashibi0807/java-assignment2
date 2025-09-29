package javaassign2;

public class WithdrawalTransaction extends Transaction {
    public WithdrawalTransaction(BankAccount account, double amount) {
        super(account, amount);
    }

    @Override
    public void process() {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal Transaction successful on " + date);
        } else {
            System.out.println("Withdrawal Transaction failed on " + date);
        }
    }
}
