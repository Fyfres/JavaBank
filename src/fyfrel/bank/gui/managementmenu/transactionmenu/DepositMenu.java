package fyfrel.bank.gui.managementmenu.transactionmenu;

import fyfrel.bank.datas.clientside.accounts.Account;
import fyfrel.bank.gui.AppWindow;
import fyfrel.bank.gui.commonlistener.CommonListener;
import fyfrel.bank.gui.managementmenu.AccountOptionMenu;
import fyfrel.bank.process.operation.AccountOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DepositMenu extends JPanel {
    private Account account;
    private AppWindow window;
    private String cardName = "DepositMenu";

    public DepositMenu(Account account, AppWindow window) {
        this.account = account;
        this.window = window;
        ArrayList error = new ArrayList();
        error.add(false);
        createDepositMenu(error);
    }

    public DepositMenu(Account account, AppWindow window, ArrayList<Object> error) {
        this.account = account;
        this.window = window;
        createDepositMenu(error);
    }

    protected void createDepositMenu(ArrayList<Object> error) {
        this.removeAll();
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel title = new JLabel("DEPOT dans le compte numéro " + account.getAccountNumber());
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(20,0,30,0);
        this.add(title, c);


        if((Boolean) error.get(0)) {
            JLabel textError = new JLabel((String) error.get(1));
            c.gridx = 0;
            c.gridy = 1;
            c.insets = new Insets(20,0,15,0);
            this.add(textError, c);
        }

        JLabel amountLabel = new JLabel("Montant à déposer :");
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(20,0,10,0);
        this.add(amountLabel, c);

        JTextField amount = new JTextField("0");
        amount.setColumns(15);
        amount.getDocument().addDocumentListener(new CommonListener.FieldNumberVerif(window, cardName, amount, 0, false));
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(0,0,20,0);
        window.getComponentToGetText().put("DepositMenu", new ArrayList<>());
        window.getComponentToGetText().get("DepositMenu").add(amount);
        this.add(amount, c);



        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints bc = new GridBagConstraints();


        JButton validate = new JButton("Confirmer");
        bc.gridx = 0;
        bc.gridy = 0;
        bc.insets = new Insets(0,20,0,20);
        validate.addActionListener(new Deposit(window, account, this));
        buttonPanel.add(validate, bc);


        JButton goBack = new JButton("Annuler");
        bc.gridx = 1;
        bc.gridy = 0;
        bc.insets = new Insets(0,20,0,20);
        goBack.addActionListener(new CommonListener.OpenAccountOptionMenuList(window, account.getAccountNumber()));
        buttonPanel.add(goBack, bc);

        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(20,0,10,0);
        this.add(buttonPanel, c);
    }



    public static class Deposit implements ActionListener {
        private AppWindow window;
        private Account account;
        private static JPanel panel;
        private DepositMenu currPanel;

        public Deposit(AppWindow receivedWindow, Account account, DepositMenu currPanel) {
            this.window = receivedWindow;
            this.account = account;
            this.currPanel = currPanel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            JTextField amount = (JTextField) window.getComponentToGetText().get("DepositMenu").get(0);

            if(AccountOperation.deposit(account, Double.parseDouble(amount.getText()))) {
                if(panel != null) {
                    window.getPanel().remove(panel);
                }
                panel = new AccountOptionMenu(account.getAccountNumber(), window);
                window.getPanel().add(panel, "AccountOptionMenu");
                window.openCard("AccountOptionMenu");
            } else {
                window.remove(currPanel);
                ArrayList<Object> temp = new ArrayList<>();
                temp.add(true);
                temp.add("Une erreur est survenue lors de la tentative de transaction.");
                window.getPanel().add(new DepositMenu(account, window, temp), "DepositMenu");
                window.getPanel().revalidate();
                window.openCard("DepositMenu");
            }
        }
    }
}
