package fyfrel.bank.gui.panels.managementmenu.transactionmenu;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.accounts.Account;
import fyfrel.bank.gui.WindowApp;
import fyfrel.bank.gui.Menu;
import fyfrel.bank.gui.commonlistener.CommonListener;
import fyfrel.bank.gui.panels.managementmenu.AccountOptionMenu;
import fyfrel.bank.process.operation.AccountOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Menu to make a payment of a certain amount to another Account
 */
public class PaymentMenu extends Menu {
    private Account account;

    /**
     * Constructor used when there is no error to display on the menu
     * @param account the Account to deposit the amount to
     * @param window AppWindow the frame of the App
     */
    public PaymentMenu(Account account, WindowApp window) {
        super(window, "PaymentMenu");
        this.account = account;

        ArrayList<Object> error = new ArrayList<>();
        error.add(false);
        createPaymentMenu(error);
    }

    /**
     * Constructor used when there is an error to display on the menu
     * @param account the Account to deposit the amount to
     * @param window AppWindow the frame of the App
     * @param error if there is an error to display and what to display {Boolean,StringToDisplay}
     */
    public PaymentMenu(Account account, WindowApp window, ArrayList<Object> error) {
        super(window, "PaymentMenu");
        this.account = account;

        createPaymentMenu(error);
    }

    /**
     * Create the core menu
     * @param error if there is an error to display and what to display {Boolean,StringToDisplay}
     */
    protected void createPaymentMenu(ArrayList<Object> error) {
        this.removeAll();
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel title = new JLabel("VIREMENT depuis le compte numéro " + account.getAccountNumber());
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






        JPanel input = new JPanel();
        input.setLayout(new GridBagLayout());
        GridBagConstraints ic = new GridBagConstraints();
        window.getComponentToGetText().put(cardName, new ArrayList<>());

        JLabel amountLabel = new JLabel("Montant à virer :");
        ic.gridx = 0;
        ic.gridy = 0;
        ic.insets = new Insets(20,0,10,0);
        input.add(amountLabel, ic);

        JTextField amount = new JTextField("0");
        amount.setColumns(15);
        amount.getDocument().addDocumentListener(new CommonListener.FieldNumberVerif(window, cardName, amount, 0, false));
        ic.gridx = 0;
        ic.gridy = 1;
        ic.insets = new Insets(0,0,20,0);
        window.getComponentToGetText().get(cardName).add(amount);
        input.add(amount, ic);


        JLabel receiverLabel = new JLabel("Numéro de compte pour le virement :");
        ic.gridx = 1;
        ic.gridy = 0;
        ic.insets = new Insets(20,0,10,0);
        input.add(receiverLabel, ic);

        JTextField receiver = new JTextField("0");
        receiver.setColumns(15);
        receiver.getDocument().addDocumentListener(new CommonListener.FieldNumberVerif(window, cardName, amount, 0, false));
        ic.gridx = 1;
        ic.gridy = 1;
        ic.insets = new Insets(0,0,20,0);
        window.getComponentToGetText().get(cardName).add(receiver);
        input.add(receiver, ic);

        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0,0,0,0);
        this.add(input, c);






        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints bc = new GridBagConstraints();


        JButton validate = new JButton("Confirmer");
        bc.gridx = 0;
        bc.gridy = 0;
        bc.insets = new Insets(0,20,0,20);
        validate.addActionListener(new Payment(window, account, this));
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


    /**
     * Save the transaction to be validated if it's the Customer that do it or make the transaction if it's an Advisor and open the Account Option Menu
     * or if there is a problem during the possible transaction re open this Menu with an error
     */
    public static class Payment implements ActionListener {
        private WindowApp window;
        private Account account;
        private static JPanel panel;
        private PaymentMenu currPanel;

        public Payment(WindowApp receivedWindow, Account account, PaymentMenu currPanel) {
            this.window = receivedWindow;
            this.account = account;
            this.currPanel = currPanel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField amount = (JTextField) window.getComponentToGetText().get("PaymentMenu").get(0);
            JTextField accountNumber = (JTextField) window.getComponentToGetText().get("PaymentMenu").get(1);

            if(AccountOperation.payment(account, Double.parseDouble(amount.getText()), Integer.parseInt(accountNumber.getText()), Bank.getManagingUser().isAdvisor())) {
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
                temp.add("Une erreur est survenue lors de la tentative de transaction.\nVeuillez vérifier le numéro de compte (et que ce n'est pas le compte sur lequel vous êtes), si celui-ci est correct vérifier que le montant saisi ne dépasse le plafond autorisé votre compte.");
                window.getPanel().add(new PaymentMenu(account, window, temp), "PaymentMenu");
                window.getPanel().revalidate();
                window.openCard("PaymentMenu");
            }
        }
    }
}
