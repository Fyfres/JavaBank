package fyfrel.bank.gui.panels.managementmenu;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.user.Advisor;
import fyfrel.bank.datas.clientside.user.Customer;
import fyfrel.bank.gui.Menu;
import fyfrel.bank.gui.WindowApp;
import fyfrel.bank.gui.commonlistener.CommonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Menu of the List of all the Customer of an Advisor
 */
public class CustomerListMenu extends Menu {
    /**
     * Constructor create the base of the Menu
     * @param window AppWindow the frame of the App
     */
    public CustomerListMenu(WindowApp window) {
        super(window, "CustomerListMenu");

        window.getComponentToGetText().put(cardName, new ArrayList<>());


        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel interestLabel = new JLabel("Liste de vos Clients :");
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



        JButton backToMenu = new JButton("Déconnexion");
        backToMenu.addActionListener(new CommonListener.BackToAuthMenu(window));
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(30, 25, 25, 0);
        this.add(backToMenu, c);


        window.getPanel().add(this, cardName);
    }

    /**
     * Create the JPanel of the list of Customer
     * @param window AppWindow the frame of the App
     */
    public static void recreateListWhenReady(WindowApp window) {
        String cardName = "CustomerListMenu";
        JPanel listPanel = (JPanel) window.getComponentToGetText().get(cardName).get(0);
        Integer y = 0;
        GridBagConstraints c = new GridBagConstraints();
        ArrayList<Customer> advisorCustomers = ((Advisor)Bank.getManagingUser()).getAllPersonalCustomer();

        for(Customer customer : advisorCustomers) {
            JPanel customerPanel = new JPanel();
            customerPanel.setLayout(new GridBagLayout());
            customerPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.black));

            GridBagConstraints cc = new GridBagConstraints();



            JLabel accountTypeLabel = new JLabel("Utilisateur " + customer.getLastname() + " " + customer.getFirstName());
            cc.gridx = 0;
            cc.gridy = 0;
            cc.insets = new Insets(10, 0, 0, 10);
            customerPanel.add(accountTypeLabel, cc);

            JButton manageCustomer = new JButton("Gérer ce client");
            manageCustomer.addActionListener(new OpenCustomerMenu(window, customer));
            cc.gridx = 1;
            cc.gridy = 0;
            cc.insets = new Insets(15,10,10,0);
            customerPanel.add(manageCustomer, cc);

            c.gridy = y;
            c.gridx = 0;
            c.insets = new Insets(10,0,10,0);
            listPanel.add(customerPanel);
            y++;
        }
    }


    /**
     * Open the managing menu of the Customer
     */
    public static class OpenCustomerMenu implements ActionListener {
        private Customer customer;
        private WindowApp window;

        public OpenCustomerMenu(WindowApp window, Customer customer) {
            this.customer = customer;
            this.window = window;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            CommonListener.changeReturnButtonInMainMenu(window);
            Bank.setManagedCustomer(customer);
            JLabel title = (JLabel) window.getComponentToGetText().get("UserMenu").get(0);
            title.setText("Bienvenue la page de gestion du client " + Bank.getManagedCustomer().getFirstName() + " " + Bank.getManagedCustomer().getLastname());
            window.openCard("UserMenu");
            return;
        }
    }
}
