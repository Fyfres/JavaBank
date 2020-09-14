package fyfrel.bank.datas.clientside.accounts;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.User;

/**
 * An Account that can get Overdraft
 */
public class CurrentAccount extends Account{
    private double overdraft;

    public double getOverdraft() {
        return overdraft;
    }
    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    /**
     * Constructor used when you know what overdraft you want to set
     * @param owner User, that will be used as the owner
     * @param amount double, Amount given at the start of the Account
     * @param overdraft double, how much in the negative the Account can be
     */
    public CurrentAccount(User owner, double amount, double overdraft) {
        super(owner, "Courant", amount);
        this.overdraft = overdraft;
    }

    /**
     * Constructor used when you don't know what overdraft you want to set
     * @param owner User, that will be used as the owner
     * @param amount double, Amount given at the start of the Account
     */
    public CurrentAccount(User owner, double amount) {
        super(owner, "Courant", amount);
        this.overdraft = Bank.getDefaultOverdraft();
    }
}
