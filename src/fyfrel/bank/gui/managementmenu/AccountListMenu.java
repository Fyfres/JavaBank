package fyfrel.bank.gui.managementmenu;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.accounts.Account;
import fyfrel.bank.gui.AppWindow;
import fyfrel.bank.gui.commonlistener.CommonListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AccountListMenu extends JPanel{
    private AppWindow window;

    public AccountListMenu(AppWindow receivedWindow) {
        this.window = receivedWindow;
        window.getComponentToGetText().put("AccountListMenu", new ArrayList<>());


        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel interestLabel = new JLabel("Liste de vos Comptes en Banque :");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(50, 0, 0, 0);
        this.add(interestLabel, c);

        JPanel list = new JPanel();
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(50, 0, 0, 0);
        list.setLayout(new GridBagLayout());
        window.getComponentToGetText().get("AccountListMenu").add(list);
        this.add(list, c);



        JButton backToMenu = new JButton("Menu Principal");
        backToMenu.addActionListener(new CommonListener.BackToMainMenu(window));
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(30, 25, 25, 0);
        this.add(backToMenu, c);


        window.getPanel().add(this, "AccountListMenu");
    }

    public static void recreateListWhenReady(JPanel listPanel, AppWindow window) {
        Integer y = 0;
        ArrayList<Account> userAccounts = Bank.getManagingUser().getAllPersonalAccount();
        GridBagConstraints c = new GridBagConstraints();

        for(Account account: userAccounts) {
            JPanel accountPanel = new JPanel();
            accountPanel.setLayout(new GridBagLayout());
            accountPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.black));

            GridBagConstraints apc = new GridBagConstraints();

            JLabel accountTypeLabel = new JLabel("Compte " + account.getAccountType());
            apc.gridx = 0;
            apc.gridy = 0;
            apc.insets = new Insets(0, 15, 0, 25);
            accountPanel.add(accountTypeLabel, apc);



            JLabel accountNumberLabel = new JLabel("Numéro de compte : " + account.getAccountNumber().toString());
            apc.gridx = 1;
            apc.gridy = 0;
            apc.insets = new Insets(0, 0, 0, 15);
            accountPanel.add(accountNumberLabel, apc);




            JLabel amountLabel = new JLabel("Solde : " + account.getContent().toString());
            apc.gridx = 0;
            apc.gridy = 1;
            apc.insets = new Insets(10, 0, 10, 0);
            accountPanel.add(amountLabel, apc);



            JButton backToMenu = new JButton("Voir ce compte");
            backToMenu.addActionListener(new CommonListener.OpenAccountOptionMenuList(window, account.getAccountNumber()));
            c.gridx = 0;
            c.gridy = 2;
            c.insets = new Insets(30, 25, 25, 0);
            accountPanel.add(backToMenu, c);


            c.gridx = 0;
            c.gridy = y;
            c.insets = new Insets(10, 0, 10, 0);
            listPanel.add(accountPanel, c);
            y++;
        }
    }





}
