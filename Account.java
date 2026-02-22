import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
public class Account {

    private final String accountNumber;
    private double balance;
    private final List<Transaction> transactionHistory;

    public Account(double initialDeposit) {
        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Initial deposit cannot be negative.");
        }

        this.accountNumber = UUID.randomUUID().toString();
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();

        if (initialDeposit > 0) {
            transactionHistory.add(
                    new Transaction(TransactionType.DEPOSIT, initialDeposit, balance)
            );
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
        validateAmount(amount);

        balance += amount;
        transactionHistory.add(
                new Transaction(TransactionType.DEPOSIT, amount, balance)
        );
    }

    public synchronized void withdraw(double amount) {
        validateAmount(amount);

        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance.");
        }

        balance -= amount;
        transactionHistory.add(
                new Transaction(TransactionType.WITHDRAWAL, amount, balance)
        );
    }

    public List<Transaction> getTransactionHistory() {
        return Collections.unmodifiableList(transactionHistory);
    }

    private void validateAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}