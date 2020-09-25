package fyfrel.bank.process.operation;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.Transaction;
import fyfrel.bank.datas.clientside.accounts.Account;

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
        if(account.canWithdraw(account, toWithdraw)) {
            account.setContent(account.getContent() - toWithdraw);
            AccountOperation.saveOperation(account, Bank.getAllTransactionTypeList()[0], toWithdraw);
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
        AccountOperation.saveOperation(account, Bank.getAllTransactionTypeList()[1], toDeposit);
        return true;
    }

    /**
     * IF an Advisor use it the payment is done
     * IF a Customer use it the payment will be stocked but will only be done when an Advisor will accept it
     * Make a payment from an account to another
     * @param account any type of Account, the one that make the action
     * @param toWithdraw double, amount to withdraw
     * @param otherAccountNumber any type of Account, the one that will receive
     * @return a Boolean if the operation was done without problem or not
     */
    public static Boolean payment(Account account, double toWithdraw, int otherAccountNumber, Boolean validated) {
        if(account.getAccountNumber() != otherAccountNumber && Account.canWithdraw(account, toWithdraw)) {
            Account otherAccount = Bank.getAllAccountList().get(otherAccountNumber);
            if(validated) {
                account.setContent(account.getContent() - toWithdraw);
                otherAccount.setContent(otherAccount.getContent() + toWithdraw);
                AccountOperation.saveOperation(account, Bank.getAllTransactionTypeList()[2], toWithdraw, otherAccount);
                AccountOperation.saveOperation(otherAccount , Bank.getAllTransactionTypeList()[3], toWithdraw, account);
            } else {
                saveOperationToValidate(account, Bank.getAllTransactionTypeList()[2], toWithdraw, otherAccount);
            }
            return true;
        }
        return false;
    }

    /**
     * Method to validate a payment a Customer might have done
     * @param account any type of Account, the one that make the action
     * @param toValidate the Transaction to validate
     * @return if the transaction was done with no trouble
     */
    public static Boolean validatePayment(Account account, Transaction toValidate) {
        Boolean temp =  payment(toValidate.getAccount(), toValidate.getAmount(), toValidate.getOtherAccount().getAccountNumber(), true);
        account.getWaitingPayment().remove(toValidate);
        return temp;
    }

    /**
     * Used to save the made transaction so that the user and the bank can keep a trace of what was done
     * Used when it involve two Account
     * @param account any type of Account, the one that make the action
     * @param typeTransaction String get in Bank->typeTransactions
     * @param amount double, amount involved
     * @param otherAccount any type of Account, the one that will receive
     */
    private static void saveOperation(Account account, String typeTransaction, double amount, Account otherAccount) {
        account.getAllTransactions().add(new Transaction(account, typeTransaction, amount, otherAccount));
    }
    /**
     * Used to save the made transaction so that the user and the bank can keep a trace of what was done
     * Used when it involve only one Account
     * @param account any type of Account
     * @param typeTransaction String get in Bank->typeTransactions
     * @param amount double, amount involved
     */
    private static void saveOperation(Account account, String typeTransaction, double amount) {
        account.getAllTransactions().add(new Transaction(account, typeTransaction, amount));
    }

    /**
     * Used to save a payment that have been done by a Customer that have to wait for the validation of an Advisor
     * @param account any type of Account, the one that make the action
     * @param typeTransaction String get in Bank->typeTransactions
     * @param amount double, amount involved
     * @param otherAccount any type of Account, the one that will receive
     */
    private static void saveOperationToValidate(Account account, String typeTransaction, double amount, Account otherAccount) {
        account.getWaitingPayment().add(new Transaction(account, typeTransaction, amount, otherAccount));
    }
}
