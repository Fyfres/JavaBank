package fyfrel.bank.process.authentication;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.user.Advisor;
import fyfrel.bank.datas.clientside.user.Customer;
import fyfrel.bank.datas.clientside.user.User;
import fyfrel.mylibrary.utility.UConsole;

public class Authentication {

    /**
     * Search in the list of all user if the firstname and lastname already exist before creating an account and calling the connect method
     * @param firstName String
     * @param lastName String
     * @param password String
     * @return if there was no problem in creating and connecting the account
     */
    public static Boolean register(String firstName, String lastName, String password, Boolean advisor) {
        for (User user : (advisor ? Bank.getAllAdvisorList() : Bank.getAllCustomerList())) {
            if(lastName.equals(user.getLastname()) && firstName.equals(user.getFirstName())) {
                    return false;
            }
        }

        if(advisor) {
            new Advisor(firstName, lastName, password);
        } else {
            new Customer(firstName, lastName, password);
        }

        connection(firstName, lastName, password, advisor);
        return true;
    }

    /**
     * Search in the list of all user if the firstname and lastname exist and if the password match then log the user
     * @param firstName String
     * @param lastName String
     * @param password String
     * @return if there was no problem connecting the account
     */
    public static Boolean connection(String firstName, String lastName, String password, Boolean advisor) {
        for (User user : (advisor ? Bank.getAllAdvisorList() : Bank.getAllCustomerList())) {
            if(lastName.equals(user.getLastname()) && firstName.equals(user.getFirstName()) && password.equals(user.getPassword())) {
                    Bank.setManagingUser(user);
                    return true;
            }
        }
        return false;
    }

    /**
     * Disconnect user and if it was an advisor the managed customer
     */
    public static void disconnect() {
        Bank.setManagingUser(null);
        Bank.setManagedCustomer(null);
    }

}
