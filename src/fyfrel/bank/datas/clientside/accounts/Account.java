package fyfrel.bank.datas.clientside.accounts;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.Transaction;
import fyfrel.bank.datas.clientside.user.Customer;
import fyfrel.mylibrary.utility.UConsole;

import java.util.ArrayList;

public abstract class Account {
    protected Integer accountNumber;
    protected Customer owner;
    protected String accountType;
    protected Double content;
    protected Boolean valid = false;
    protected ArrayList<Transaction> allTransactions = new ArrayList<>();
    protected ArrayList<Transaction> waitingPayment = new ArrayList<>();

    public Integer getAccountNumber() {
        return accountNumber;
    }
    public Customer getOwner() {
        return owner;
    }
    public void setOwner(Customer owner) {
        this.owner = owner;
    }
    public String getAccountType() {
        return accountType;
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
    public ArrayList<Transaction> getWaitingPayment() {
        return waitingPayment;
    }
    public Boolean isValid() {
        return valid;
    }
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    /**
     * Constructor
     * @param owner User, that will be used as the owner
     * @param accountType String, that is given by the class that extends Account in their own constructor
     * @param content double, Amount given at the start of the Account
     */
    public Account(Customer owner, String accountType, double content) {
        this.owner = owner;
        this.accountType = accountType;
        this.content = content;
        this.addToList();
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
     * TODO !! ADD AN ELSE IF HERE IF YOU ADD A NEW TYPE OF ACCOUNT !!
     * @param account any type of Account
     * @param toWithdraw amount to withdraw
     * @return if the amount can be withdrawn without problem
     */
    public static Boolean canWithdraw(Account account, double toWithdraw) {
        if(account.isCurrent()) {
            return ((CurrentAccount) account).canWithdraw(toWithdraw);
        } else if(account.isSaving()) {
            return ((SavingAccount) account).canWithdraw(toWithdraw);
        }
        UConsole.error("Couldn't find the type of Account.");
        return false;
    }





    // TODO !! ADD A "isTypeOfAccount" METHOD WHENEVER YOU CREATE A NEW TYPE OF ACCOUNT !!


    /**
     * Test if an Account can be Cast to a CurrentAccount
     * @return a Boolean if the account can be cast or not
     */
    public Boolean isCurrent() {
        return this instanceof CurrentAccount;
    }

    /**
     * Test if an Account can be Cast to a SavingAccount
     * @return a Boolean if the account can be cast or not
     */
    public Boolean isSaving() {
        return this instanceof SavingAccount;
    }

    public abstract Boolean canWithdraw(double toWithdraw);
}
