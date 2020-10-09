package fyfrel.bank.datas.clientside.user;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.accounts.Account;

import java.io.Serializable;
import java.util.ArrayList;

// A User that cannot do everything he is managed by an Advisor
public class Customer extends User implements Serializable {
    private ArrayList<Account> allPersonalAccount = new ArrayList<>();

    public ArrayList<Account> getAllPersonalAccount() {
        return allPersonalAccount;
    }
    public void setAllPersonnalAccount(ArrayList<Account> allPersonnalAccount) {
        this.allPersonalAccount = allPersonnalAccount;
    }

    public Customer(String firstName, String lastname, String password) {
        super(firstName, lastname, password);
        Bank.getAllCustomerList().add(this);
        Bank.getAdvisorWithLeastCustomer().getAllPersonalCustomer().add(this);
    }

    @Override
    public String getClassName() {
        return "Customer";
    }
}
