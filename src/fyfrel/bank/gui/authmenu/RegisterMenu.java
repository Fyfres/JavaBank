package fyfrel.bank.gui.authmenu;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.gui.AppWindow;
import fyfrel.bank.gui.commonlistener.CommonListener;
import fyfrel.bank.process.authentication.Authentication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegisterMenu extends JPanel {
    private AppWindow window;


    public RegisterMenu(AppWindow receivedWindow) {
        window = receivedWindow;

        window.getComponentToGetText().put("RegisterMenu" , new ArrayList<>());
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
        window.getComponentToGetText().get("RegisterMenu").add(firstName);
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
        window.getComponentToGetText().get("RegisterMenu").add(lastName);
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
        window.getComponentToGetText().get("RegisterMenu").add(password);
        card.add(password, c);

        JButton register = new JButton("Créer un Compte");
        register.addActionListener(new UserCreation());
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(100, 0, 0, 0);
        card.add(register, c);

        JButton backAuthMenu = new JButton("Retour");
        backAuthMenu.addActionListener(new CommonListener.BackToAuthMenu(window));
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(25, 0, 0, 0);
        card.add(backAuthMenu, c);

        window.getPanel().add(card, "RegisterMenu");
    }



    public class UserCreation implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Object> components = window.getComponentToGetText().get("RegisterMenu");
            JTextField firstName = (JTextField) components.get(0);
            JTextField lastName = (JTextField) components.get(1);
            JPasswordField password = (JPasswordField) components.get(2);
            if(Authentication.register(firstName.getText(), lastName.getText(), password.getText())) {
                JLabel title = (JLabel) window.getComponentToGetText().get("UserMenu").get(0);
                title.setText("Bienvenue sur votre page de gestion " + Bank.getManagingUser().getFirstName() + " " + Bank.getManagingUser().getLastname());
                window.openCard("UserMenu");
                return;
            }
            window.openCard("AlreadyExist");
        }
    }
}