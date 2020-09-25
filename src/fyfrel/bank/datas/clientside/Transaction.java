package fyfrel.bank.datas.clientside;

import fyfrel.bank.datas.clientside.accounts.Account;

/**
 * Class created when a transaction is done to save what was done by a user
 */
public class Transaction {
    private Account account;
    private String transactionType;
    private Double amount;
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
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public Account getOtherAccount() {
        return otherAccount;
    }
    public void setOtherAccount(Account otherAccount) {
        this.otherAccount = otherAccount;
    }

    /**
     * Constructor used when the transaction is between TWO Users
     * @param account instance of User by the owner of the Account
     * @param transactionType String of the type of transaction done
     * @param amount double that will be transferred
     * @param otherAccount instance of User by the owner of the second Account
     */
    public Transaction(Account account, String transactionType, double amount, Account otherAccount) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
        this.otherAccount = otherAccount;
    }

    /**
     * Constructor used when the transaction is done only by the owner of the account
     * @param account instance of User by the owner of the Account
     * @param transactionType String of the type of transaction done
     * @param amount double that will be transferred
     */
    public Transaction(Account account, String transactionType, double amount) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public String getClassName() {
        return "Transaction";
    }
}
