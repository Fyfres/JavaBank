package fyfrel.bank.gui.panels.managementmenu;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.Transaction;
import fyfrel.bank.datas.clientside.accounts.Account;
import fyfrel.bank.gui.WindowApp;
import fyfrel.bank.gui.Menu;
import fyfrel.bank.gui.commonlistener.CommonListener;
import fyfrel.bank.gui.panels.managementmenu.transactionmenu.DepositMenu;
import fyfrel.bank.gui.panels.managementmenu.transactionmenu.PaymentMenu;
import fyfrel.bank.gui.panels.managementmenu.transactionmenu.WithdrawMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountOptionMenu extends Menu {
    private Integer accountNumber;
    private Account account;

    public AccountOptionMenu(Integer receivedAccountNumber, WindowApp receivedWindow) {
        super(receivedWindow, "AccountOptionMenu");

        accountNumber = receivedAccountNumber;
        account = Bank.getAllAccountList().get(accountNumber);
        createAccountOptionMenu();
    }

    private void createAccountOptionMenu() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel title = new JLabel("Gestion du compte numéro " + accountNumber);
        c.gridy = 0;
        c.gridx = 0;
        c.insets = new Insets(0,0,20,0);
        this.add(title, c);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints bc = new GridBagConstraints();

        JButton openWithdrawMenu = new JButton("Faire un Retrait");
        openWithdrawMenu.addActionListener(new OpenWithdrawMenu(window, account));
        bc.gridy = 0;
        bc.gridx = 0;
        bc.insets = new Insets(0,10,0,10);
        buttonPanel.add(openWithdrawMenu, bc);

        JButton openDepositMenu = new JButton("Faire un Dépôt");
        openDepositMenu.addActionListener(new OpenDepositMenu(window, account));
        bc.gridy = 0;
        bc.gridx = 1;
        bc.insets = new Insets(0,10,0,10);
        buttonPanel.add(openDepositMenu, bc);

        JButton openPaymentMenu = new JButton("Faire un Virement");
        openPaymentMenu.addActionListener(new OpenPaymentMenu(window, account));
        bc.gridy = 0;
        bc.gridx = 2;
        bc.insets = new Insets(0,10,0,10);
        buttonPanel.add(openPaymentMenu, bc);

        JButton backToAccountListMenu = new JButton("Retour");
        backToAccountListMenu.addActionListener(new CommonListener.OpenListAccountMenu(window));
        bc.gridy = 0;
        bc.gridx = 3;
        bc.insets = new Insets(0,10,0,10);
        buttonPanel.add(backToAccountListMenu, bc);

        c.gridy = 1;
        c.gridx = 0;
        c.insets = new Insets(50,0,50,0);
        this.add(buttonPanel, c);

        JScrollPane scrollTransactions = new JScrollPane(createAllTransaction());
        c.gridy = 2;
        c.gridx = 0;
        c.insets = new Insets(50,0,20,0);
        scrollTransactions.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        this.add(scrollTransactions, c);
    }

    private JPanel createAllTransaction() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        int i = 0;

        for (Transaction transaction : account.getAllTransactions()) {
            JPanel transactionPanel = new JPanel();
            transactionPanel.setLayout(new GridBagLayout());
            GridBagConstraints tc = new GridBagConstraints();

            JLabel type = new JLabel(transaction.getTransactionType());
            tc.gridy = 0;
            tc.gridx = 0;
            tc.insets = new Insets(20,0,20,50);
            transactionPanel.add(type, tc);

            JLabel amount = new JLabel(transaction.getAmount().toString());
            tc.gridy = 0;
            tc.gridx = 1;
            tc.insets = new Insets(20,0,20,50);
            transactionPanel.add(amount, tc);

            c.fill = GridBagConstraints.BOTH;
            c.gridx = 0;
            c.gridy = i;
            c.weightx = 1.0;
            i++;
            transactionPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
            panel.add(transactionPanel,c);
        }
        return panel;
    }







    public static class OpenWithdrawMenu implements ActionListener {
        private WindowApp window;
        private Account account;
        private static JPanel panel;

        public OpenWithdrawMenu(WindowApp receivedWindow, Account account) {
            this.window = receivedWindow;
            this.account = account;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(panel != null) {
                window.getPanel().remove(panel);
            }
            panel = new WithdrawMenu(account, window);
            window.getPanel().add(panel, "WithdrawMenu");
            window.openCard("WithdrawMenu");
        }
    }


    public static class OpenDepositMenu implements ActionListener {
        private WindowApp window;
        private Account account;
        private static JPanel panel;

        public OpenDepositMenu(WindowApp receivedWindow, Account account) {
            this.window = receivedWindow;
            this.account = account;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(panel != null) {
                window.getPanel().remove(panel);
            }

            panel = new DepositMenu(account, window);
            window.getPanel().add(panel, "DepositMenu");
            window.openCard("DepositMenu");
        }
    }


    public static class OpenPaymentMenu implements ActionListener {
        private WindowApp window;
        private Account account;
        private static JPanel panel;

        public OpenPaymentMenu(WindowApp receivedWindow, Account account) {
            this.window = receivedWindow;
            this.account = account;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(panel != null) {
                window.getPanel().remove(panel);
            }

            panel = new PaymentMenu(account, window);
            window.getPanel().add(panel, "PaymentMenu");
            window.openCard("PaymentMenu");
        }
    }


}
