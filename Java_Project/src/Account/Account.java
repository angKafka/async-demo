package Account;

import Customer.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private int accountNumber;
    private double balance;
    private Customer customer;
    private List<Transaction> transactions;

    public Account(int accountNumber, Customer customer, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = initialDeposit;
        this.transactions = new ArrayList<>();
        addTransaction(new Transaction(transactions.size() + 1, initialDeposit, new Date(), "Deposit"));
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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        balance += amount;
        addTransaction(new Transaction(transactions.size() + 1, amount, new Date(), "Deposit"));
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            addTransaction(new Transaction(transactions.size() + 1, amount, new Date(), "Withdrawal"));
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
