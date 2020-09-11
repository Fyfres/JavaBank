package fyfrel.bank.datas.clientside.accounts;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.Transaction;
import fyfrel.bank.datas.clientside.User;

import java.util.ArrayList;

public abstract class Account {
    protected Integer accountNumber;
    protected User owner;
    protected String accountType;
    protected double content;
    protected ArrayList<Transaction> allTransactions = new ArrayList<>();

    public Integer getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }
    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public double getContent() {
        return content;
    }
    public void setContent(double content) {
        this.content = content;
    }
    public ArrayList<Transaction> getAllTransactions() {
        return allTransactions;
    }
    public void setAllTransactions(ArrayList<Transaction> allTransactions) {
        this.allTransactions = allTransactions;
    }

    public Account(User owner, String accountType, double content) {
        this.owner = owner;
        this.accountType = accountType;
        this.content = content;
        this.addToList();
    }

    /**
     * Auto-Increment of AccountNumber
     * And add the account to the Bank list and it's User list
     */
    protected void addToList() {
        Bank.setLastAccountNumber(Bank.getLastAccountNumber()+1);
        if(Bank.getAllAccountList().size() <= 0) {
            this.accountNumber = 1;
        } else {
            this.accountNumber = Bank.getLastAccountNumber();
        }
        Bank.getAllAccountList().put(this.accountNumber, this);
        this.owner.getAllPersonnalAccount().add(this);
    }
}
