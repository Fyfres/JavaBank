package fyfrel.bank.datas.clientside.accounts;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.User;

/**
 * An Account that can't get overdraft but get interest "every month"
 */
public class SavingAccount extends Account {
    private double interest;

    public double getInterest() {
        return interest;
    }
    public void setInterest(double interest) {
        this.interest = interest;
    }

    /**
     * Constructor used when you know what interest you want to set
     * @param owner User, that will be used as the owner
     * @param amount double, Amount given at the start of the Account
     * @param interest double, by how much percentage the Amount will grow each month
     */
    public SavingAccount(User owner, double amount, double interest) {
        super(owner, "Epargne", amount);
        this.interest = interest;
    }

    /**
     * Constructor used when you don't know what interest you want to set
     * @param owner User, that will be used as the owner
     * @param amount double, Amount given at the start of the Account
     */
    public SavingAccount(User owner, double amount) {
        super(owner, "Epargne", amount);
        this.interest = Bank.getDefaultInterest();
    }

    /**
     * Add the setted percentage of € to the account amount
     */
    public void addInterest() {
        this.content += (this.content*this.interest)/100;
    }


    /**
     * Test if the amount to withdraw isn't to high
     * @param toWithdraw amount to withdraw
     * @return if the amount can be withdrawn without problem
     */
    public Boolean canWithdraw(double toWithdraw) {
        if(toWithdraw > this.getContent()) {
            return false;
        }
        return true;
    }
}
