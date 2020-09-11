package fyfrel.bank.datas.bankside;

import fyfrel.bank.datas.clientside.User;
import fyfrel.bank.datas.clientside.accounts.Account;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    private static ArrayList<User> allUserList = new ArrayList<>();
    private static HashMap<Integer, Account> allAccountList = new HashMap<>();
    private static ArrayList<String> allTransactionTypeList = new ArrayList<>();
    private static User managingUser;
    private static int lastAccountNumber = 0;

    // These are the value by default for each type of account
    private static final double DEFAULT_INTEREST = 15;
    private static final double DEFAULT_OVERDRAFT = 200;

    public static double getDefaultInterest() {
        return DEFAULT_INTEREST;
    }
    public static double getDefaultOverdraft() {
        return DEFAULT_OVERDRAFT;
    }

    public static ArrayList<User> getAllUserList() {
        return allUserList;
    }
    public static void setAllUserList(ArrayList<User> allUserList) {
        Bank.allUserList = allUserList;
    }
    public static HashMap<Integer, Account> getAllAccountList() {
        return allAccountList;
    }
    public static void setAllAccountList(HashMap<Integer, Account> allAccountList) {
        Bank.allAccountList = allAccountList;
    }
    public static ArrayList<String> getAllTransactionTypeList() {
        return allTransactionTypeList;
    }
    public static void setAllTransactionTypeList(ArrayList<String> allTransactionTypeList) {
        Bank.allTransactionTypeList = allTransactionTypeList;
    }
    public static int getLastAccountNumber() {
        return lastAccountNumber;
    }
    public static void setLastAccountNumber(int lastAccountNumber) {
        Bank.lastAccountNumber = lastAccountNumber;
    }
    public static User getManagingUser() {
        return managingUser;
    }
    public static void setManagingUser(User managingUser) {
        Bank.managingUser = managingUser;
    }

    public static void INIT_VALUE() {
        Bank.allTransactionTypeList.add("Retrait");
        Bank.allTransactionTypeList.add("Versement");
        Bank.allTransactionTypeList.add("Virement");
        Bank.allTransactionTypeList.add("Versement Externe");
    }
}
