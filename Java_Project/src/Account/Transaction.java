package Account;

import java.util.Date;

public class Transaction {
    private int transactionId;
    private double amount;
    private Date date;
    private String type;

    public Transaction(int transactionId, double amount, Date date, String type) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getDetails() {
        return "Account.Transaction ID: " + transactionId + ", Amount: " + amount + ", Date: " + date + ", Type: " + type;
    }
}

