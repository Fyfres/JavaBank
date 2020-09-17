package fyfrel.bank.gui.managementmenu;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.accounts.CurrentAccount;
import fyfrel.bank.datas.clientside.accounts.SavingAccount;
import fyfrel.bank.gui.AppWindow;
import fyfrel.bank.gui.commonlistener.CommonListener;


import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewAccountMenu extends JPanel {
    private static AppWindow window;

    public static NewAccountMenu[] createNewAccountMenu(AppWindow window) {
        return new NewAccountMenu[]{new NewAccountMenu(window, Bank.getAccountTypes()[0]), new NewAccountMenu(window, Bank.getAccountTypes()[1])};
    }

    public NewAccountMenu(AppWindow receivedwindow, String name) {
        window = receivedwindow;
        createNewAccountMenu(name);
    }

    private void createNewAccountMenu(String cardName) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        window.getComponentToGetText().put(cardName , new ArrayList<>());


        JLabel title = new JLabel("Création de compte :");
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(50, 0, 50, 0);
        this.add(title, c);




        JLabel accountTypeLabel = new JLabel("Type de compte :");
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(50, 0, 0, 0);
        this.add(accountTypeLabel, c);

        // !! ADD ANY NEW TYPE OF ACCOUNT HERE !!
        JComboBox accountType = new JComboBox(Bank.getAccountTypes());
        if(cardName.equals(Bank.getAccountTypes()[0])) {
            accountType.setSelectedIndex(0);
        } else if (cardName.equals(Bank.getAccountTypes()[1])) {
            accountType.setSelectedIndex(1);
        }
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(20, 0, 0, 0);
        window.getComponentToGetText().get(cardName).add(accountType);
        accountType.addActionListener(new AccountTypeSelect(cardName));
        this.add(accountType, c);




        JLabel amountLabel = new JLabel("Montant de départ :");
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(50, 0, 0, 0);
        this.add(amountLabel, c);

        JTextField amount = new JTextField();
        amount.setColumns(15);
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(20, 0, 0, 0);
        window.getComponentToGetText().get(cardName).add(amount);
        amount.getDocument().addDocumentListener(new CommonListener.FieldNumberVerif(window, cardName, amount, 1, false));
        this.add(amount, c);




        if(cardName.equals(Bank.getAccountTypes()[0])) {
            JLabel overdraftLabel = new JLabel("Découvert autorisé (en négatif) :");
            c.gridx = 2;
            c.gridy = 2;
            c.insets = new Insets(50, 0, 0, 0);
            this.add(overdraftLabel, c);


            JTextField overdraft = new JTextField();
            overdraft.setText("-");
            overdraft.setColumns(15);
            c.gridx = 2;
            c.gridy = 3;
            c.insets = new Insets(20, 0, 0, 0);
            window.getComponentToGetText().get(cardName).add(overdraft);
            overdraft.getDocument().addDocumentListener(new CommonListener.FieldNumberVerif(window, cardName, amount, 1, true));
            this.add(overdraft, c);


        } else if(cardName.equals(Bank.getAccountTypes()[1])) {
            JLabel interestLabel = new JLabel("Pourcentage d'intérêt par mois :");
            c.gridx = 2;
            c.gridy = 2;
            c.insets = new Insets(50, 0, 0, 0);
            this.add(interestLabel, c);


            JTextField interest = new JTextField();
            interest.setColumns(15);
            c.gridx = 2;
            c.gridy = 3;
            c.insets = new Insets(20, 0, 0, 0);
            window.getComponentToGetText().get(cardName).add(interest);
            interest.getDocument().addDocumentListener(new CommonListener.FieldNumberVerif(window, cardName, amount, 1, false));
            this.add(interest, c);
        }

        JButton listAccount = new JButton("Créer le Compte " + accountType.getSelectedItem());
        listAccount.addActionListener(new NewAccountCreationEvent(cardName));
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(30, 25, 25, 0);
        this.add(listAccount, c);


        JButton backToMenu = new JButton("Menu Principal");
        backToMenu.addActionListener(new CommonListener.BackToMainMenu(window));
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(30, 25, 25, 0);
        this.add(backToMenu, c);


        window.getPanel().add(this, cardName);
    }












    public static class NewAccountCreationEvent implements ActionListener {

        private String name;

        public NewAccountCreationEvent(String name) {
            this.name = name;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField amountTF = (JTextField) window.getComponentToGetText().get(name).get(1);
            JTextField miscTF = (JTextField) window.getComponentToGetText().get(name).get(2);

            double amount = Double.parseDouble(amountTF.getText());
            double misc = Double.parseDouble(miscTF.getText());

            // !! ADD CREATION OF ACCOUNT FOR ANY NEW TYPE OF ACCOUNT !!
            if(name.equals(Bank.getAccountTypes()[0])) {
                new CurrentAccount(Bank.getManagingUser(), amount, misc);
            } else if(name.equals(Bank.getAccountTypes()[1])) {
                new SavingAccount(Bank.getManagingUser(), amount, misc);
            }
            window.openCard("UserMenu");
        }
    }



    public static class AccountTypeSelect implements ActionListener {

        private String name;

        public AccountTypeSelect(String name) {
            this.name = name;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox toOpen = (JComboBox) e.getSource();
            window.openCard(toOpen.getSelectedItem().toString());
            toOpen.setSelectedItem(name);
        }
    }
}
