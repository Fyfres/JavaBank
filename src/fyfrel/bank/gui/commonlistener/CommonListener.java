package fyfrel.bank.gui.commonlistener;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.Transaction;
import fyfrel.bank.gui.WindowApp;
import fyfrel.bank.gui.panels.managementmenu.AccountListMenu;
import fyfrel.bank.gui.panels.managementmenu.AccountOptionMenu;
import fyfrel.bank.gui.panels.managementmenu.CustomerListMenu;
import fyfrel.bank.process.authentication.Authentication;
import fyfrel.mylibrary.utility.UConsole;
import fyfrel.mylibrary.utility.UMath;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommonListener {

    /**
     * Listener on a TextField that check if the user input a number or a negative number depending on what's needed
     */
    public static class FieldNumberVerif implements DocumentListener {
        private JTextField field;
        private Boolean negative;
        private WindowApp window;
        private String cardName;
        private Integer index;

        public FieldNumberVerif(WindowApp window, String cardName, JTextField field, Integer index, Boolean negative) {
            this.window = window;
            this.field = field;
            this.negative = negative;
            this.cardName = cardName;
            this.index = index;
        }



        @Override
        public void insertUpdate(DocumentEvent e) {
            fieldNumberVerif();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            return;
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            fieldNumberVerif();
        }

        public void fieldNumberVerif() {

            SwingUtilities.invokeLater(() -> {
                if(!UMath.testStringToDouble(field.getText())
                        || field.getText().substring(field.getText().length() - 1).equals("f")
                        || field.getText().substring(field.getText().length() - 1).equals("d")
                        || field.getText().substring(field.getText().length() - 1).equals("F")
                        || field.getText().substring(field.getText().length() - 1).equals("D")
                ) {
                    if(negative) {
                        if(field.getText().substring(0).equals("-") && field.getText().length() <= 1) {
                            return;
                        } else {
                            field.setText("-0");
                            return;
                        }
                    } else {
                        field.setText("0");
                        return;
                    }
                }
                if(negative && Double.parseDouble(field.getText()) > 0){
                    field.setText("0");
                }
            });
        }
    }


    /**
     * Listener that open the Authentication Menu
     */
    public static class BackToAuthMenu implements ActionListener {
        private WindowApp window;

        public BackToAuthMenu(WindowApp receivedWindow) {
            this.window = receivedWindow;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Authentication.disconnect();
            window.openCard("AuthMenu");
        }
    }


    /**
     * Listener that open the Customer Menu
     */
    public static class BackToMainMenu implements ActionListener {
        private WindowApp window;

        public BackToMainMenu(WindowApp receivedWindow) {
            this.window = receivedWindow;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            changeReturnButtonInMainMenu(window);
            if(Bank.getManagingUser().isCustomer()) {
                JLabel title = (JLabel) window.getComponentToGetText().get("UserMenu").get(0);
                title.setText("Bienvenue votre page de gestion " + Bank.getManagingUser().getFirstName() + " " + Bank.getManagingUser().getLastname());
                window.openCard("UserMenu");
                return;
            } else if(Bank.getManagingUser().isAdvisor()) {
                JLabel title = (JLabel) window.getComponentToGetText().get("UserMenu").get(0);
                title.setText("Bienvenue la page de gestion du client " + Bank.getManagedCustomer().getFirstName() + " " + Bank.getManagedCustomer().getLastname());
                window.openCard("UserMenu");
                return;
            }
        }
    }


    /**
     * Listener that open the list of account of a Customer
     */
    public static class OpenListAccountMenu implements ActionListener {
        private WindowApp window;

        public OpenListAccountMenu(WindowApp window) {
            this.window = window;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JPanel listPanel = (JPanel) window.getComponentToGetText().get("AccountListMenu").get(0);
            listPanel.removeAll();
            AccountListMenu.recreateListWhenReady(listPanel, window);

            window.openCard("AccountListMenu");
        }
    }


    /**
     * Listener that open the Menu with all the option of an Account
     */
    public static class OpenAccountOptionMenuList implements ActionListener {
        private WindowApp window;
        private Integer accountNumber;
        private static JPanel panel;

        public OpenAccountOptionMenuList(WindowApp receivedWindow, Integer accountNumber) {
            this.window = receivedWindow;
            this.accountNumber = accountNumber;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if(panel != null) {
                window.getPanel().remove(panel);
            }
            panel = new AccountOptionMenu(accountNumber, window);
            window.getPanel().add(panel, "AccountOptionMenu");
            window.openCard("AccountOptionMenu");
        }
    }


    /**
     * Listener that Open the Menu with Customer List
     */
    public static class ReturnCustomerList implements ActionListener{
        private WindowApp window;

        public ReturnCustomerList(WindowApp window) {
            this.window = window;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JPanel listPanel = (JPanel) window.getComponentToGetText().get("CustomerListMenu").get(0);
            listPanel.removeAll();
            CustomerListMenu.recreateListWhenReady(window);
            window.openCard("CustomerListMenu");
            return;
        }
    }


    /**
     * Methods to change the return button depending on the role of the managing User
     * @param window WindowApp the frame of the App
     */
    public static void changeReturnButtonInMainMenu(WindowApp window) {
        JButton returnButton = (JButton) window.getComponentToGetText().get("UserMenu").get(1);
        ActionListener[] ElToRemove = returnButton.getActionListeners();
        for (ActionListener toRemove: ElToRemove) {
            returnButton.removeActionListener(toRemove);
        }

        if(Bank.getManagingUser().isAdvisor()) {
            returnButton.setText("Retour Liste des clients");
            returnButton.addActionListener(new ReturnCustomerList(window));
        } else if(Bank.getManagingUser().isCustomer()) {
            returnButton.setText("Déconnexion");
            returnButton.addActionListener(new BackToAuthMenu(window));
        }
    }


}
