package fyfrel.bank.gui.managementmenu;

import fyfrel.bank.gui.AppWindow;

import javax.swing.*;
import java.awt.*;

public class AccountOptionMenu extends JPanel {
    private Integer accountNumber;
    private AppWindow window;

    public AccountOptionMenu(Integer receivedAccountNumber, AppWindow receivedWindow) {
        accountNumber = receivedAccountNumber;
        window = receivedWindow;
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

        // TODO add action listener for each button

        JButton openWithdrawMenu = new JButton("Faire un Retrait");
        c.gridy = 1;
        c.gridx = 0;
        c.insets = new Insets(50,0,20,0);
        this.add(openWithdrawMenu, c);

        JButton openDepositMenu = new JButton("Faire un Dépôt");
        c.gridy = 1;
        c.gridx = 1;
        c.insets = new Insets(50,0,20,0);
        this.add(openDepositMenu, c);

        JButton openPaymentMenu = new JButton("Faire un Virement");
        c.gridy = 1;
        c.gridx = 2;
        c.insets = new Insets(50,0,20,0);
        this.add(openPaymentMenu, c);

        JButton backToAccountListMenu = new JButton("Retour");
        c.gridy = 1;
        c.gridx = 3;
        c.insets = new Insets(50,0,20,0);
        this.add(backToAccountListMenu, c);

        JScrollPane scrollTransactions = new JScrollPane(createAllTransaction());
        c.gridy = 1;
        c.gridx = 4;
        c.insets = new Insets(50,0,20,0);
        this.add(scrollTransactions, c);
    }

    private JPanel createAllTransaction() {
        return new JPanel();
    }
}
