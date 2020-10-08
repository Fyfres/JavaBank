package fyfrel.bank.gui.panels.authmenu;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.gui.WindowApp;
import fyfrel.bank.gui.Menu;
import fyfrel.bank.gui.commonlistener.CommonListener;
import fyfrel.bank.gui.panels.managementmenu.CustomerListMenu;
import fyfrel.bank.process.authentication.Authentication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Menu to connect
 */
public class ConnectionMenu extends Menu {

    /**
     * Create the menu original and the one when the connection didn't go well
     * @param receivedWindow AppWindow the frame of the App
     * @return the two Menu
     */
    public static ConnectionMenu[] createConnectionMenu(WindowApp receivedWindow) {
        return new ConnectionMenu[]{new ConnectionMenu(receivedWindow, false), new ConnectionMenu(receivedWindow, true)};
    }


    /**
     * Launch the creation of the menu with an error if there is a need
     * @param receivedWindow AppWindow the frame of the App
     * @param error Boolean if there is an error to display or not
     */
    public ConnectionMenu(WindowApp receivedWindow, Boolean error) {
        super(receivedWindow, error ? "ErrorConnectionMenu" : "ConnectionMenu");

        if(error) {
            this.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            JLabel title = new JLabel("Les identifiants ou mot de passe ne correspondent pas.");
            c.gridx = 0;
            c.gridy = 0;
            this.add(title, c);

            createConnectionMenu(c);
        } else {
            this.setLayout(new GridBagLayout());
            createConnectionMenu(new GridBagConstraints());
        }
    }


    /**
     * Create the core of the menu
     * @param c GridBagConstraint
     */
    private void createConnectionMenu(GridBagConstraints c) {
        window.getComponentToGetText().put(cardName , new ArrayList<>());

        JLabel title = new JLabel("Connexion utilisateur");
        c.gridx = 0;
        c.gridy = 1;
        this.add(title, c);



        JLabel firstNameLabel = new JLabel("Votre prénom : ");
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(100, 0, 0, 0);
        this.add(firstNameLabel, c);

        JTextField firstName = new JTextField();
        window.getComponentToGetText().get(cardName).add(firstName);
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(20, 0, 0, 0);
        firstName.setColumns(15);
        this.add(firstName, c);



        JLabel lastNameLabel = new JLabel("Votre nom : ");
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(50, 0, 0, 0);
        this.add(lastNameLabel, c);

        JTextField lastName = new JTextField();
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(20, 0, 0, 0);
        lastName.setColumns(15);
        window.getComponentToGetText().get(cardName).add(lastName);
        this.add(lastName, c);



        JLabel passwordLabel = new JLabel("Votre mot de passe : ");
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(50, 0, 0, 0);
        this.add(passwordLabel, c);

        JPasswordField password = new JPasswordField();
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(20, 0, 0, 0);
        password.setColumns(15);
        window.getComponentToGetText().get(cardName).add(password);
        this.add(password, c);



        JCheckBox advisor = new JCheckBox("Cochez si vous vous connectez à un compte de Conseiller");
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(20, 0, 0, 0);
        window.getComponentToGetText().get(cardName).add(advisor);
        this.add(advisor, c);



        JButton register = new JButton("Se connecter");
        register.addActionListener(new UserConnection());
        c.gridx = 0;
        c.gridy = 9;
        c.insets = new Insets(100, 0, 0, 0);
        this.add(register, c);

        JButton backAuthMenu = new JButton("Retour");
        backAuthMenu.addActionListener(new CommonListener.BackToAuthMenu(window));
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(25, 0, 0, 0);
        this.add(backAuthMenu, c);

        window.getPanel().add(this, cardName);
    }


    /**
     * Listener that send a Customer to it's managing page or send an Advisor to it's Customer List
     * or send the User an error if it couldn't be connected
     */
    public class UserConnection implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Object> components = window.getComponentToGetText().get(cardName);
            JTextField firstName = (JTextField) components.get(0);
            JTextField lastName = (JTextField) components.get(1);
            JPasswordField password = (JPasswordField) components.get(2);
            JCheckBox advisor = (JCheckBox) components.get(3);

            CommonListener.emptyAllFieldsOfActivePanel(window);

            if(Authentication.connection(firstName.getText(), lastName.getText(), password.getText(), advisor.isSelected())) {
                if(Bank.getManagingUser().isCustomer()) {
                    JLabel title = (JLabel) window.getComponentToGetText().get("UserMenu").get(0);
                    title.setText("Bienvenue votre page de gestion " + Bank.getManagingUser().getFirstName() + " " + Bank.getManagingUser().getLastname());
                    window.openCard("UserMenu");
                    return;
                } else if(Bank.getManagingUser().isAdvisor()) {
                    JPanel listPanel = (JPanel) window.getComponentToGetText().get("CustomerListMenu").get(0);
                    listPanel.removeAll();
                    CustomerListMenu.recreateListWhenReady(window);
                    window.openCard("CustomerListMenu");
                    return;
                }

            }
            window.openCard("ErrorConnectionMenu");
        }
    }
}


