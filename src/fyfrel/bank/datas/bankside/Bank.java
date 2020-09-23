package fyfrel.bank.datas.bankside;

import fyfrel.bank.datas.clientside.user.Advisor;
import fyfrel.bank.datas.clientside.user.Customer;
import fyfrel.bank.datas.clientside.user.User;
import fyfrel.bank.datas.clientside.accounts.Account;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    // Managed by the app
    private static ArrayList<Customer> allCustomerList = new ArrayList<>();
    private static ArrayList<Advisor> allAdvisorList = new ArrayList<>();
    private static HashMap<Integer, Account> allAccountList = new HashMap<>();
    private static final String[] allTransactionTypeList = {"Retrait", "Versement", "Virement", "Versement Externe"};
    private static User managingUser;
    private static Customer managedCustomer;

    // !! IF YOU CREATE ANY NEW TYPE OF ACCOUNT ADD THEM HERE !!
    private static final String[] ACCOUNT_TYPES = {"Courant", "Epargne"};

    // These are the value by default for each type of account
    private static final double DEFAULT_INTEREST = 15;
    private static final double DEFAULT_OVERDRAFT = -200;

    // Start number of AccountNumber (ex : first created account will be 1 and it'll auto-increment each time)
    private static int LAST_ACCOUNT_NUMBER = 0;


    public static String[] getAccountTypes() {
        return ACCOUNT_TYPES;
    }
    public static String[] getAllTransactionTypeList() {
        return allTransactionTypeList;
    }
    public static double getDefaultInterest() {
        return DEFAULT_INTEREST;
    }
    public static double getDefaultOverdraft() {
        return DEFAULT_OVERDRAFT;
    }

    public static int getLastAccountNumber() {
        return LAST_ACCOUNT_NUMBER;
    }
    public static void setLastAccountNumber(int lastAccountNumber) {
        Bank.LAST_ACCOUNT_NUMBER = lastAccountNumber;
    }

    public static ArrayList<Customer> getAllCustomerList() {
        return allCustomerList;
    }
    public static void setAllCustomerList(ArrayList<Customer> allUserList) {
        Bank.allCustomerList = allUserList;
    }
    public static ArrayList<Advisor> getAllAdvisorList() {
        return allAdvisorList;
    }
    public static void setAllAdvisorList(ArrayList<Advisor> allUserList) {
        Bank.allAdvisorList = allUserList;
    }
    public static Advisor getAdvisorWithLeastCustomer() {
        Advisor advisorToReturn = Bank.getAllAdvisorList().get(0);
        for(Advisor advisor : Bank.getAllAdvisorList()){
            if(advisorToReturn.getAllPersonalCustomer().size() > advisor.getAllPersonalCustomer().size()) {
                advisorToReturn = advisor;
            }
        }
        return advisorToReturn;
    }

    public static HashMap<Integer, Account> getAllAccountList() {
        return allAccountList;
    }
    public static void setAllAccountList(HashMap<Integer, Account> allAccountList) {
        Bank.allAccountList = allAccountList;
    }

    public static User getManagingUser() {
        return managingUser;
    }
    public static void setManagingUser(User managingUser) {
        Bank.managingUser = managingUser;
    }
    public static Customer getManagedCustomer() {
        return managedCustomer;
    }
    public static void setManagedCustomer(Customer managedCustomer) {
        Bank.managedCustomer = managedCustomer;
    }
}
