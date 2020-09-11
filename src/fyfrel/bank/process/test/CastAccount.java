package fyfrel.bank.process.test;

import fyfrel.bank.datas.clientside.accounts.Account;
import fyfrel.bank.datas.clientside.accounts.CurrentAccount;
import fyfrel.bank.datas.clientside.accounts.SavingAccount;

/**
 * !! ADD A "isTypeOfAccount" METHOD WHENEVER YOU CREATE A NEW TYPE OF ACCOUNT !!
 */
public class CastAccount {
    public static Boolean isCurrent(Account account) {
        try{
            CurrentAccount temp = (CurrentAccount) account;
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    public static Boolean isSaving(Account account) {
        try{
            SavingAccount temp = (SavingAccount) account;
        } catch(Exception e) {
            return false;
        }
        return true;
    }
}
