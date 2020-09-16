package fyfrel.bank.process.authentication;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.User;
import fyfrel.mylibrary.utility.UConsole;

import java.util.ArrayList;

public class Authentication {
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

    public static void disconnect() {
        Bank.setManagingUser(null);
    }
}
