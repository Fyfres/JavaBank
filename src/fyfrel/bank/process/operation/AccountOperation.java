package fyfrel.bank.process.operation;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.Transaction;
import fyfrel.bank.datas.clientside.accounts.Account;
import fyfrel.bank.process.test.TestAccountOperation;

/**
 * Class used each time an action on the amount of an account must be done
 */
public class AccountOperation {

    /**
     * Withdraw an amount from an Account
     * @param account any type of Account
     * @param toWithdraw double, amount to withdraw
     * @return a Boolean if the operation was done without problem or not
     */
    public static Boolean withdraw(Account account, double toWithdraw) {
        if(TestAccountOperation.canWithdraw(account, toWithdraw)) {
            account.setContent(account.getContent() - toWithdraw);
            AccountOperation.saveOperation(account, Bank.getAllTransactionTypeList().get(0), toWithdraw);
            return true;
        }
        return false;
    }

    /**
     * Deposit an amount to an Account
     * @param account any type of Account
     * @param toDeposit double, amount to deposit
     * @return a Boolean if the operation was done without problem or not
     */
    public static Boolean deposit(Account account, double toDeposit) {
        account.setContent(account.getContent() + toDeposit);
        AccountOperation.saveOperation(account, Bank.getAllTransactionTypeList().get(1), toDeposit);
        return true;
    }

    /**
     * Make a payment from an Account to another one
     * @param account any type of Account, the one that make the action
     * @param toWithdraw double, amount to withdraw
     * @param otherAccountNumber any type of Account, the one that will receive
     * @return a Boolean if the operation was done without problem or not
     */
    public static Boolean payment(Account account, double toWithdraw, int otherAccountNumber) {
        if(TestAccountOperation.canWithdraw(account, toWithdraw)) {
            Account otherAccount = Bank.getAllAccountList().get(otherAccountNumber);
            account.setContent(account.getContent() - toWithdraw);
            AccountOperation.saveOperation(account, Bank.getAllTransactionTypeList().get(2), toWithdraw, otherAccount);
            AccountOperation.saveOperation(otherAccount , Bank.getAllTransactionTypeList().get(3), toWithdraw, account);
            return true;
        }
        return false;
    }

    /**
     * Used to save the made transaction so that the user and the bank can keep a trace of what was done
     * Used when it involve two Account
     * @param account any type of Account, the one that make the action
     * @param typeTransaction String get in Bank->typeTransactions
     * @param amount double, amount involved
     * @param otherAccount any type of Account, the one that will receive
     */
    public static void saveOperation(Account account, String typeTransaction, double amount, Account otherAccount) {
        account.getAllTransactions().add(new Transaction(account, typeTransaction, amount, otherAccount));
    }
    /**
     * Used to save the made transaction so that the user and the bank can keep a trace of what was done
     * Used when it involve only one Account
     * @param account any type of Account
     * @param typeTransaction String get in Bank->typeTransactions
     * @param amount double, amount involved
     */
    public static void saveOperation(Account account, String typeTransaction, double amount) {
        account.getAllTransactions().add(new Transaction(account, typeTransaction, amount));
    }
}
