package fyfrel.bank.datas.clientside.accounts;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.User;

public class SavingAccount extends Account {
    private double interest;

    public double getInterest() {
        return interest;
    }
    public void setInterest(double interest) {
        this.interest = interest;
    }

    public SavingAccount(User user, double amount, double interest) {
        super(user, "Epargne", amount);
        this.interest = interest;
    }

    public SavingAccount(User user, double amount) {
        super(user, "Epargne", amount);
        this.interest = Bank.getDefaultInterest();
    }

    /**
     * Add the setted percentage of € to the account amount
     */
    public void addInterest() {
        this.content += (this.content*this.interest)/100;
    }
}
