package fyfrel.bank.process.test;

import fyfrel.bank.datas.clientside.accounts.Account;
import fyfrel.bank.datas.clientside.accounts.CurrentAccount;
import fyfrel.bank.datas.clientside.accounts.SavingAccount;

/**
 * !! ADD A "isTypeOfAccount" METHOD WHENEVER YOU CREATE A NEW TYPE OF ACCOUNT !!
 * Class used to test an Account to see in which type you can cast it
 */
public class CastAccount {
    /**
     * Test if an Account can be Cast to a CurrentAccount
     * @param account Account
     * @return a Boolean if the account can be cast or not
     */
    public static Boolean isCurrent(Account account) {
        try{
            CurrentAccount temp = (CurrentAccount) account;
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Test if an Account can be Cast to a SavingAccount
     * @param account Account
     * @return a Boolean if the account can be cast or not
     */
    public static Boolean isSaving(Account account) {
        try{
            SavingAccount temp = (SavingAccount) account;
        } catch(Exception e) {
            return false;
        }
        return true;
    }
}
