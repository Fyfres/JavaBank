package fyfrel.bank.process.test;

import fyfrel.bank.datas.clientside.accounts.Account;
import fyfrel.bank.datas.clientside.accounts.CurrentAccount;
import fyfrel.bank.datas.clientside.accounts.SavingAccount;
import fyfrel.mylibrary.utility.UConsole;

/**
 * !! ADD A "canWithdraw" METHOD FOR ANY NEW TYPE OF ACCOUNT YOU MIGHT CREATE !!
 */
public class TestAccountOperation {
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
            return TestAccountOperation.canWithdraw(currentAccount, toWithdraw);
        } else if(CastAccount.isSaving(account)) {
            SavingAccount savingAccount = (SavingAccount) account;
            return TestAccountOperation.canWithdraw(savingAccount, toWithdraw);
        }
        UConsole.error("Couldn't find the type of Account.");
        return false;
    }

    /**
     * Test if the amount to withdraw isn't to high
     * @param account SavingAccount
     * @param toWithdraw amount to withdraw
     * @return if the amount can be withdrawn without problem
     */
    public static Boolean canWithdraw(SavingAccount account, double toWithdraw) {
        if(toWithdraw > account.getContent()) {
            return false;
        }
        return true;
    }

    /**
     * Test if the amount to withdraw isn't to high
     * @param account CurrentAccount
     * @param toWithdraw amount to withdraw
     * @return if the amount can be withdrawn without problem
     */
    public static Boolean canWithdraw(CurrentAccount account, double toWithdraw) {
        if(account.getContent() - toWithdraw < account.getOverdraft()) {
            return false;
        }
        return true;
    }
}
