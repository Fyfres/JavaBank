package fyfrel.bank.datas.clientside;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.accounts.Account;

import java.util.ArrayList;

/**
 * Basic User class that can contain multiple Bank Account
 */
public class User {
    private String firstName;
    private String lastname;
    private String password;
    private ArrayList<Account> allPersonalAccount = new ArrayList<>();

    public ArrayList<Account> getAllPersonalAccount() {
        return allPersonalAccount;
    }
    public void setAllPersonnalAccount(ArrayList<Account> allPersonnalAccount) {
        this.allPersonalAccount = allPersonnalAccount;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Constructor that add the new instance to the list of user in Class Bank
     * @param firstName String
     * @param lastname String
     * @param password String
     */
    public User(String firstName, String lastname, String password) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.password = password;
        Bank.getAllUserList().add(this);
    }
}
