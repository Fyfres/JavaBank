package fyfrel.bank.gui.authmenu;

import fyfrel.bank.gui.AppWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthMainMenu extends JPanel{
    private AppWindow window;

    public static AuthMainMenu[] createAuthMainMenu(AppWindow receivedWindow) {
        return new AuthMainMenu[]{new AuthMainMenu(receivedWindow, false), new AuthMainMenu(receivedWindow, true)};
    }

    public AuthMainMenu(AppWindow receivedWindow, Boolean error) {
        this.window = receivedWindow;

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
            createAuthMenu("AuthMenu", c);
        }

    }

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



    public class Connection implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            window.openCard("ConnectionMenu");
        }
    }

    public class Register implements ActionListener {
        @Override
        public  void    actionPerformed(ActionEvent e) {
            window.openCard("RegisterMenu");
        }
    }
}
