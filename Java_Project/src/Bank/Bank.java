package Bank;

import Account.Account;
import Customer.Customer;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public Account createAccount(Customer customer, double initialDeposit) {
        int accountNumber = accounts.size() + 1;
        Account newAccount = new Account(accountNumber, customer, initialDeposit);
        accounts.add(newAccount);
        return newAccount;
    }

    public Account getAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
