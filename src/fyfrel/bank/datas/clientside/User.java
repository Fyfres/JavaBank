package fyfrel.bank.datas.clientside;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.accounts.Account;

import java.util.ArrayList;

public class User {
    private String firstName;
    private String lastname;
    private String password;
    private ArrayList<Account> allPersonnalAccount = new ArrayList<>();

    public ArrayList<Account> getAllPersonnalAccount() {
        return allPersonnalAccount;
    }
    public void setAllPersonnalAccount(ArrayList<Account> allPersonnalAccount) {
        this.allPersonnalAccount = allPersonnalAccount;
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

    public User(String firstName, String lastname, String password) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.password = password;
        Bank.getAllUserList().add(this);
    }
}
