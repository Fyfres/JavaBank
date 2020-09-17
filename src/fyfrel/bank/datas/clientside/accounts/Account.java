package fyfrel.bank.datas.clientside.accounts;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.Transaction;
import fyfrel.bank.datas.clientside.User;
import fyfrel.bank.process.operation.AccountOperation;
import fyfrel.bank.process.test.CastAccount;
import fyfrel.mylibrary.utility.UConsole;

import java.util.ArrayList;

public abstract class Account {
    protected Integer accountNumber;
    protected User owner;
    protected String accountType;
    protected Double content;
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
    public Double getContent() {
        return content;
    }
    public void setContent(Double content) {
        this.content = content;
    }
    public ArrayList<Transaction> getAllTransactions() {
        return allTransactions;
    }
    public void setAllTransactions(ArrayList<Transaction> allTransactions) {
        this.allTransactions = allTransactions;
    }

    /**
     * Constructor
     * @param owner User, that will be used as the owner
     * @param accountType String, that is given by the class that extends Account in their own constructor
     * @param content double, Amount given at the start of the Account
     */
    public Account(User owner, String accountType, double content) {
        this.owner = owner;
        this.accountType = accountType;
        this.content = content;
        this.addToList();
        //TODO remove this shit
        AccountOperation.deposit(this, 20);
    }

    /**
     * Auto-Increment of AccountNumber
     * And add the account to the Bank list and it's owner list of Account
     */
    protected void addToList() {
        Bank.setLastAccountNumber(Bank.getLastAccountNumber()+1);
        if(Bank.getAllAccountList().size() <= 0) {
            this.accountNumber = 1;
        } else {
            this.accountNumber = Bank.getLastAccountNumber();
        }
        Bank.getAllAccountList().put(this.accountNumber, this);
        this.owner.getAllPersonalAccount().add(this);
    }



    /**
     * Test the type of account then test if the amount to withdraw isn't to high
     * !! ADD AN ELSE IF HERE IF YOU ADD A NEW TYPE OF ACCOUNT !!
     * @param account any type of Account
     * @param toWithdraw amount to withdraw
     * @return if the amount can be withdrawn without problem
     */
    public static Boolean canWithdraw(Account account, double toWithdraw) {
        if(CastAccount.isCurrent(account)) {
            CurrentAccount currentAccount = (CurrentAccount) account;
            return currentAccount.canWithdraw(toWithdraw);
        } else if(CastAccount.isSaving(account)) {
            SavingAccount savingAccount = (SavingAccount) account;
            return savingAccount.canWithdraw(toWithdraw);
        }
        UConsole.error("Couldn't find the type of Account.");
        return false;
    }
}
