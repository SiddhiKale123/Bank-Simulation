public class Main {

    public static void main(String[] args) {

        Account account = new Account(1000);

        account.deposit(500);
        account.withdraw(200);

        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Current Balance: " + account.getBalance());

        System.out.println("\nTransaction History:");
        for (Transaction transaction : account.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }
}