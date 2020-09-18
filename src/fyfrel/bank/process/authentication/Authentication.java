package fyfrel.bank.process.authentication;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.User;

import java.util.ArrayList;

public class Authentication {

    /**
     * Search in the list of all user if the firstname and lastname already exist before creating an account and calling the connect method
     * @param firstName String
     * @param lastName String
     * @param password String
     * @return if there was no problem in creating and connecting the account
     */
    public static Boolean register(String firstName, String lastName, String password) {
        ArrayList<User> allUser = Bank.getAllUserList();
        for (int i = 0; i < allUser.size(); i++) {
            User user = allUser.get(i);
            if(lastName.equals(user.getLastname()) && firstName.equals(user.getFirstName())) {
                return false;
            }
        }
        new User(firstName, lastName, password);
        connection(firstName, lastName, password);
        return true;
    }

    /**
     * Search in the list of all user if the firstname and lastname exist and if the password match then log the user
     * @param firstName String
     * @param lastName String
     * @param password String
     * @return if there was no problem connecting the account
     */
    public static Boolean connection(String firstName, String lastName, String password) {
        ArrayList<User> allUser = Bank.getAllUserList();
        for (int i = 0; i < allUser.size(); i++) {
            User user = allUser.get(i);
            if(lastName.equals(user.getLastname()) && firstName.equals(user.getFirstName()) && password.equals(user.getPassword())) {
                Bank.setManagingUser(user);
                return true;
            }
        }
        return false;
    }

    /**
     * Like the method tell it just Disconnect the user
     */
    public static void disconnect() {
        Bank.setManagingUser(null);
    }
}
