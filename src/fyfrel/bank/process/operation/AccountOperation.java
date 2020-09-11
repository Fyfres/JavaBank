package fyfrel.bank.process.operation;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.Transaction;
import fyfrel.bank.datas.clientside.accounts.Account;
import fyfrel.bank.process.test.TestAccountOperation;

public class AccountOperation {
    public static Boolean withdraw(Account account, double toWithdraw) {
        if(TestAccountOperation.canWithdraw(account, toWithdraw)) {
            account.setContent(account.getContent() - toWithdraw);
            AccountOperation.saveOperation(account, Bank.getAllTransactionTypeList().get(0), toWithdraw);
            return true;
        }
        return false;
    }

    public static Boolean deposit(Account account, double toDeposit) {
        account.setContent(account.getContent() + toDeposit);
        AccountOperation.saveOperation(account, Bank.getAllTransactionTypeList().get(1), toDeposit);
        return true;
    }

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

    public static void saveOperation(Account account, String typeTransaction, double amount, Account otherAccount) {
        account.getAllTransactions().add(new Transaction(account, typeTransaction, amount, otherAccount));
    }
    public static void saveOperation(Account account, String typeTransaction, double amount) {
        account.getAllTransactions().add(new Transaction(account, typeTransaction, amount));
    }
}
