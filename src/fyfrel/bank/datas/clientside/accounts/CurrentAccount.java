package fyfrel.bank.datas.clientside.accounts;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.User;

public class CurrentAccount extends Account{
    private double overdraft;

    public double getOverdraft() {
        return overdraft;
    }
    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public CurrentAccount(User user, double amount, double overdraft) {
        super(user, "Courant", amount);
        this.overdraft = overdraft;
    }

    public CurrentAccount(User user, double amount) {
        super(user, "Courant", amount);
        this.overdraft = Bank.getDefaultOverdraft();
    }
}
