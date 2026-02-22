import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Transaction {

    private final TransactionType type;
    private final double amount;
    private final double balanceAfterTransaction;
    private final LocalDateTime timestamp;

    public Transaction(TransactionType type, double amount, double balanceAfterTransaction) {
        this.type = type;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
        this.timestamp = LocalDateTime.now();
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "[" + timestamp.format(formatter) + "] " +
                type +
                " | Amount: " + amount +
                " | Balance: " + balanceAfterTransaction;
    }
}
