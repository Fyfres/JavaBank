package fyfrel.bank.datas.clientside;

import fyfrel.bank.datas.clientside.accounts.Account;

public class Transaction {
    private Account account;
    private String transactionType;
    private double amount;
    private Account otherAccount;

    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public String getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public Account getOtherAccount() {
        return otherAccount;
    }
    public void setOtherAccount(Account otherAccount) {
        this.otherAccount = otherAccount;
    }

    public Transaction(Account account, String transactionType, double amount, Account otherAccount) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
        this.otherAccount = otherAccount;
    }

    public Transaction(Account account, String transactionType, double amount) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
    }
}
