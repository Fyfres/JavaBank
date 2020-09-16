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

public class ConnectionMenu extends JPanel{
    private AppWindow window;

    public static ConnectionMenu[] createConnectionMenu(AppWindow receivedWindow) {
        return new ConnectionMenu[]{new ConnectionMenu(receivedWindow, false), new ConnectionMenu(receivedWindow, true)};
    }


    public ConnectionMenu(AppWindow receivedWindow, Boolean error) {
        this.window = receivedWindow;
        if(error) {
            this.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            JLabel title = new JLabel("Les identifiants ou mot de passe ne correspondent pas.");
            c.gridx = 0;
            c.gridy = 0;
            this.add(title, c);

            createConnectionMenu("ErrorConnectionMenu", c);
        } else {
            this.setLayout(new GridBagLayout());
            createConnectionMenu("ConnectionMenu", new GridBagConstraints());
        }
    }

    private void createConnectionMenu(String cardName, GridBagConstraints c) {
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




        JButton register = new JButton("Se connecter");
        register.addActionListener(new UserConnection(cardName));
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(100, 0, 0, 0);
        this.add(register, c);

        JButton backAuthMenu = new JButton("Retour");
        backAuthMenu.addActionListener(new CommonListener.BackToAuthMenu(window));
        c.gridx = 0;
        c.gridy = 9;
        c.insets = new Insets(25, 0, 0, 0);
        this.add(backAuthMenu, c);

        window.getPanel().add(this, cardName);
    }






    public class UserConnection implements ActionListener {
        private String name;

        public UserConnection(String name) {
            this.name = name;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Object> components = window.getComponentToGetText().get(name);
            JTextField firstName = (JTextField) components.get(0);
            JTextField lastName = (JTextField) components.get(1);
            JPasswordField password = (JPasswordField) components.get(2);
            if(Authentication.connection(firstName.getText(), lastName.getText(), password.getText())) {
                JLabel title = (JLabel) window.getComponentToGetText().get("UserMenu").get(0);
                title.setText("Bienvenue sur votre page de gestion " + Bank.getManagingUser().getFirstName() + " " + Bank.getManagingUser().getLastname());
                window.openCard("UserMenu");
                return;
            }
            window.openCard("ErrorConnectionMenu");
        }
    }
}


