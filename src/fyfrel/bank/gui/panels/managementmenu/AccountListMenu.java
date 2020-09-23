package fyfrel.bank.gui.panels.managementmenu;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.accounts.Account;
import fyfrel.bank.datas.clientside.user.Customer;
import fyfrel.bank.gui.WindowApp;
import fyfrel.bank.gui.Menu;
import fyfrel.bank.gui.commonlistener.CommonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Menu of the list of Account of a Customer
 */
public class AccountListMenu extends Menu {

    /**
     * Create the core menu
     * @param receivedWindow AppWindow the frame of the App
     */
    public AccountListMenu(WindowApp receivedWindow) {
        super(receivedWindow, "AccountListMenu");
        window.getComponentToGetText().put(cardName, new ArrayList<>());


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
        window.getComponentToGetText().get(cardName).add(list);
        this.add(list, c);



        JButton backToMenu = new JButton("Menu Principal");
        backToMenu.addActionListener(new CommonListener.BackToMainMenu(window));
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(30, 25, 25, 0);
        this.add(backToMenu, c);


        window.getPanel().add(this, cardName);
    }

    /**
     * Create the list of Account to display
     * @param listPanel the panel that is used to display the list
     * @param window AppWindow the frame of the App
     */
    public static void recreateListWhenReady(JPanel listPanel, WindowApp window) {

        Integer y = 0;
        ArrayList<Account> userAccounts = null;
        if(Bank.getManagingUser().isAdvisor()) {
            userAccounts = Bank.getManagedCustomer().getAllPersonalAccount();
        } else if(Bank.getManagingUser().isCustomer()) {
            Customer user = (Customer) Bank.getManagingUser();
            userAccounts = user.getAllPersonalAccount();
        }
        GridBagConstraints c = new GridBagConstraints();

        for(Account account: userAccounts) {
            if(!account.isValid() && Bank.getManagingUser().isCustomer()) {
                continue;
            }

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




            JLabel amountLabel = new JLabel("Solde : " + account.getContent().toString() + "€");
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


            if(!account.isValid()) {
                JButton authorizeAccount = new JButton("Valider ce compte");
                authorizeAccount.addActionListener(new AuthorizeAccount(window, account));
                c.gridx = 1;
                c.gridy = 2;
                c.insets = new Insets(30, 25, 25, 0);
                accountPanel.add(authorizeAccount, c);
            }



            c.gridx = 0;
            c.gridy = y;
            c.insets = new Insets(10, 0, 10, 0);
            listPanel.add(accountPanel, c);
            y++;
        }
    }

    /**
     * Method to Validate an Account (Only usable by an Advisor)
     */
    public static class AuthorizeAccount implements ActionListener {
        private WindowApp window;
        private Account account;
        private JPanel listPanel;

        public AuthorizeAccount(WindowApp window, Account account) {
            this.window = window;
            this.account = account;
            this.listPanel = (JPanel) window.getComponentToGetText().get("AccountListMenu").get(0);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            account.setValid(true);
            listPanel.removeAll();
            recreateListWhenReady(listPanel, window);
            window.openCard("AccountListMenu");
            window.revalidate();
        }
    }
}
