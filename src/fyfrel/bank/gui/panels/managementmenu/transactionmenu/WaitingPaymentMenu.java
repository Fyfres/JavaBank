package fyfrel.bank.gui.panels.managementmenu.transactionmenu;

import fyfrel.bank.datas.clientside.Transaction;
import fyfrel.bank.datas.clientside.accounts.Account;
import fyfrel.bank.gui.Menu;
import fyfrel.bank.gui.WindowApp;
import fyfrel.bank.gui.commonlistener.CommonListener;
import fyfrel.bank.process.operation.AccountOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Menu of the list of Payment of an Account waiting to be validated by an Advisor
 */
public class WaitingPaymentMenu  extends Menu {
    private Account account;

    /**
     * Create the base of the menu
     * @param account Account of the Customer
     * @param window AppWindow the frame of the App
     */
    public WaitingPaymentMenu(Account account, WindowApp window) {
        super(window, "WaitingPaymentMenu");
        this.account = account;

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel title = new JLabel("Liste des virements en attente de validation");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(15,0,20,0);
        this.add(title, c);

        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10,0,20,0);
        this.add(createListWaitingPayment(), c);


        JButton goBack = new JButton("Retour");
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0,20,0,20);
        goBack.addActionListener(new CommonListener.OpenAccountOptionMenuList(window, account.getAccountNumber()));
        this.add(goBack, c);

    }

    /**
     * Create the panel containing the list of waiting payment
     * @return a JPanel
     */
    private JPanel createListWaitingPayment() {
        Integer y = 0;
        JPanel list = new JPanel();
        list.setLayout(new GridBagLayout());


        for (Transaction waitingTransaction : account.getWaitingPayment()) {
            JPanel payment = new JPanel();
            payment.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            payment.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.black));

            JLabel label = new JLabel("Virement de " + waitingTransaction.getAmount() + "€ vers le compte n°" + waitingTransaction.getOtherAccount().getAccountNumber());
            c.gridx = 0;
            c.gridy = 0;
            c.insets = new Insets(10,0,5,0);
            payment.add(label, c);

            JButton validate = new JButton("Valider ce virement");
            validate.addActionListener(new ValidatePayment(waitingTransaction));
            c.gridx = 0;
            c.gridy = 1;
            c.insets = new Insets(5,0,10,0);
            payment.add(validate, c);

            c.gridx = 0;
            c.gridy = y;
            c.insets = new Insets(10,0,10,0);
            y++;
            list.add(payment,c);
        }

        return list;
    }

    /**
     * Validate a Payment and refresh the menu
     */
    private class ValidatePayment implements ActionListener {

        private Transaction transaction;

        public ValidatePayment(Transaction transaction) {
            this.transaction = transaction;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            AccountOperation.validatePayment(account, transaction);
            window.getPanel().add(new WaitingPaymentMenu(account, window) , "WaitingPaymentMenu");
            CommonListener.emptyAllFieldsOfActivePanel(window);
            window.openCard("WaitingPaymentMenu");
        }
    }
}
