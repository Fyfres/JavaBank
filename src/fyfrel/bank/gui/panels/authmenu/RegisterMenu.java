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
 * Menu to register
 */
public class RegisterMenu extends Menu {

    /**
     * the constructor create all the Menu
     * @param receivedWindow AppWindow the frame of the App
     */
    public RegisterMenu(WindowApp receivedWindow) {
        super(receivedWindow, "RegisterMenu");

        window.getComponentToGetText().put(cardName , new ArrayList<>());
        JPanel card = new JPanel();
        card.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel title = new JLabel("Création d'un nouvel utilisateur");
        c.gridx = 0;
        c.gridy = 0;
        card.add(title, c);



        JLabel firstNameLabel = new JLabel("Votre prénom : ");
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(100, 0, 0, 0);
        card.add(firstNameLabel, c);

        JTextField firstName = new JTextField();
        window.getComponentToGetText().get(cardName).add(firstName);
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(20, 0, 0, 0);
        firstName.setColumns(15);
        card.add(firstName, c);



        JLabel lastNameLabel = new JLabel("Votre nom : ");
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(50, 0, 0, 0);
        card.add(lastNameLabel, c);

        JTextField lastName = new JTextField();
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(20, 0, 0, 0);
        lastName.setColumns(15);
        window.getComponentToGetText().get(cardName).add(lastName);
        card.add(lastName, c);



        JLabel passwordLabel = new JLabel("Votre mot de passe : ");
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(50, 0, 0, 0);
        card.add(passwordLabel, c);

        JPasswordField password = new JPasswordField();
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(20, 0, 0, 0);
        password.setColumns(15);
        window.getComponentToGetText().get(cardName).add(password);
        card.add(password, c);



        JCheckBox advisor = new JCheckBox("Cochez si vous créez un compte de Conseiller");
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(20, 0, 0, 0);
        window.getComponentToGetText().get(cardName).add(advisor);
        card.add(advisor, c);






        JButton register = new JButton("Créer un Compte");
        register.addActionListener(new UserCreation());
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(100, 0, 0, 0);
        card.add(register, c);

        JButton backAuthMenu = new JButton("Retour");
        backAuthMenu.addActionListener(new CommonListener.BackToAuthMenu(window));
        c.gridx = 0;
        c.gridy = 9;
        c.insets = new Insets(25, 0, 0, 0);
        card.add(backAuthMenu, c);

        window.getPanel().add(card, cardName);
    }


    /**
     * Listener that send a Customer to it's managing page or send an Advisor to it's Customer List
     * or send the User an error if it couldn't be registered or connected
     */
    public class UserCreation implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Object> components = window.getComponentToGetText().get(cardName);
            JTextField firstName = (JTextField) components.get(0);
            JTextField lastName = (JTextField) components.get(1);
            JPasswordField password = (JPasswordField) components.get(2);
            JCheckBox advisor = (JCheckBox) components.get(3);

            if(Authentication.register(firstName.getText(), lastName.getText(), password.getText(), advisor.isSelected())) {
                if(Bank.getManagingUser().isCustomer()) {
                    JLabel title = (JLabel) window.getComponentToGetText().get("UserMenu").get(0);
                    title.setText("Bienvenue sur votre page de gestion " + Bank.getManagingUser().getFirstName() + " " + Bank.getManagingUser().getLastname());
                    CommonListener.emptyAllFieldsOfActivePanel(window);
                    window.openCard("UserMenu");
                    return;
                } else if(Bank.getManagingUser().isAdvisor()) {
                    JPanel listPanel = (JPanel) window.getComponentToGetText().get("CustomerListMenu").get(0);
                    listPanel.removeAll();
                    CustomerListMenu.recreateListWhenReady(window);
                    CommonListener.emptyAllFieldsOfActivePanel(window);
                    window.openCard("CustomerListMenu");
                    return;
                }
            }
            CommonListener.emptyAllFieldsOfActivePanel(window);
            window.openCard("AlreadyExist");
        }
    }
}
