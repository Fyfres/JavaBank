package fyfrel.bank.datas.bankside;

import fyfrel.bank.datas.clientside.User;
import fyfrel.bank.datas.clientside.accounts.Account;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    // Managed by the app
    private static ArrayList<User> allUserList = new ArrayList<>();
    private static HashMap<Integer, Account> allAccountList = new HashMap<>();
    private static final String[] allTransactionTypeList = {"Retrait", "Versement", "Virement", "Versement Externe"};
    private static User managingUser;

    // !! IF YOU CREATE ANY NEW TYPE OF ACCOUNT ADD THEM HERE !!
    private static final String[] ACCOUNT_TYPES = {"Courant", "Epargne"};

    // These are the value by default for each type of account
    private static final double DEFAULT_INTEREST = 15;
    private static final double DEFAULT_OVERDRAFT = -200;

    // Don't touch this unless you're sure of chat you're doing
    private static int LAST_ACCOUNT_NUMBER = 0;


    public static String[] getAccountTypes() {
        return ACCOUNT_TYPES;
    }
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
    public static String[] getAllTransactionTypeList() {
        return allTransactionTypeList;
    }
    public static int getLastAccountNumber() {
        return LAST_ACCOUNT_NUMBER;
    }
    public static void setLastAccountNumber(int lastAccountNumber) {
        Bank.LAST_ACCOUNT_NUMBER = lastAccountNumber;
    }
    public static User getManagingUser() {
        return managingUser;
    }
    public static void setManagingUser(User managingUser) {
        Bank.managingUser = managingUser;
    }
}
