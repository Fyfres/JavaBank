package fyfrel.bank.gui.panels;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.gui.Menu;
import fyfrel.bank.gui.WindowApp;
import fyfrel.bank.gui.commonlistener.CommonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenu extends Menu {

    public MainMenu(WindowApp receivedWindow) {
        super(receivedWindow, "UserMenu");

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        window.getComponentToGetText().put(cardName , new ArrayList<>());

        JLabel imgLabel = new JLabel(window.getAppIcon());
        c.gridx = 1;
        c.gridy = 0;
        this.add(imgLabel, c);

        JLabel title = new JLabel("");
        c.gridx = 1;
        c.gridy = 1;
        window.getComponentToGetText().get(cardName).add(title);
        this.add(title, c);


        JButton listAccount = new JButton("Aperçu de mes Comptes");
        listAccount.addActionListener(new CommonListener.OpenListAccountMenu(window));
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(30, 0, 0, 0);
        this.add(listAccount, c);



        JButton newAccount = new JButton("Créer un nouveau Compte");
        newAccount.addActionListener(new OpenNewAccountMenu());
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(30, 25, 0, 25);
        this.add(newAccount, c);


        JButton backAuthMenu = new JButton("Déconnexion");
        backAuthMenu.addActionListener(new CommonListener.BackToAuthMenu(window));
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(30,0, 0, 0);
        this.add(backAuthMenu, c);


        window.getPanel().add(this, cardName);
    }




    public class OpenNewAccountMenu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            window.openCard(Bank.getAccountTypes()[0]);
        }
    }

}
