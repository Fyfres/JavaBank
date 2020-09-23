package fyfrel.bank.gui.panels.authmenu;

import fyfrel.bank.gui.WindowApp;
import fyfrel.bank.gui.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Menu to choose either to connect or register
 */
public class AuthMainMenu extends Menu {

    /**
     * Create the menu original and the one when the register didn't go well
     * @param receivedWindow AppWindow the frame of the App
     * @return the two Menu
     */
    public static AuthMainMenu[] createAuthMainMenu(WindowApp receivedWindow) {
        return new AuthMainMenu[]{new AuthMainMenu(receivedWindow, false), new AuthMainMenu(receivedWindow, true)};
    }

    /**
     * Launch the creation of the menu with the corresponding name depending if there is an error to display or not
     * @param receivedWindow AppWindow the frame of the App
     * @param error Boolean if there is an error to display or not
     */
    public AuthMainMenu(WindowApp receivedWindow, Boolean error) {
        super(receivedWindow, "AuthMenu");

        if(error) {
            this.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            JLabel registerError = new JLabel("Vous avez déjà un compte");
            c.gridx = 1;
            c.gridy = 0;
            c.insets = new Insets(0, 0, 50, 0);
            this.add(registerError, c);

            createAuthMenu("AlreadyExist", c);
        } else {
            GridBagConstraints c = new GridBagConstraints();
            createAuthMenu(cardName, c);
        }

    }

    /**
     * Create the core of the menu
     * @param cardName String
     * @param c GridBagConstraint
     */
    private void createAuthMenu(String cardName, GridBagConstraints c) {
        JButton login = new JButton("Connexion");
        login.addActionListener(new Connection());
        c.gridx = 0;
        c.gridy = 1;
        this.add(login, c);

        JButton register = new JButton("Créer un Compte");
        register.addActionListener(new Register());
        c.gridx = 2;
        c.gridy = 1;
        this.add(register, c);

        window.getPanel().add(this, cardName);
    }


    /**
     * Open the connection Menu
     */
    public class Connection implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            window.openCard("ConnectionMenu");
        }
    }

    /**
     * Open the Register Menu
     */
    public class Register implements ActionListener {
        @Override
        public  void    actionPerformed(ActionEvent e) {
            window.openCard("RegisterMenu");
        }
    }
}
