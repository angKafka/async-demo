import Account.Account;
import Account.Transaction;
import Bank.Bank;
import Customer.Customer;

public class Main {
    public static void main(String[] args) {
        // Create a bank
        Bank bank = new Bank("OpenAI Bank");

        // Create a customer
        Customer customer = new Customer(1, "John Doe", "123 Main St");

        // Create an account for the customer
        Account account = bank.createAccount(customer, 1000.0);

        // Perform some transactions
        account.deposit(500.0);
        account.withdraw(200.0);

        // Print account details
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Customer: " + account.getCustomer().getDetails());

        // Print transactions
        System.out.println("Transactions:");
        for (Transaction transaction : account.getTransactions()) {
            System.out.println(transaction.getDetails());
        }
    }
}

