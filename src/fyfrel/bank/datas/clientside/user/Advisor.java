package fyfrel.bank.datas.clientside.user;

import fyfrel.bank.datas.bankside.Bank;

import java.io.Serializable;
import java.util.ArrayList;

// User managing Customer
public class Advisor extends User implements Serializable {
    private ArrayList<Customer> allPersonalCustomer = new ArrayList<>();

    public ArrayList<Customer> getAllPersonalCustomer() {
        return allPersonalCustomer;
    }
    public void setAllPersonalCustomer(ArrayList<Customer> allPersonalCustomer) {
        this.allPersonalCustomer = allPersonalCustomer;
    }

    public Advisor(String firstName, String lastname, String password) {
        super(firstName, lastname, password);
        Bank.getAllAdvisorList().add(this);
    }

    @Override
    public String getClassName() {
        return "Advisor";
    }
}
