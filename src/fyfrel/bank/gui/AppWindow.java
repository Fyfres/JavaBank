package fyfrel.bank.gui;

import fyfrel.bank.process.authentication.Authentication;
import fyfrel.mylibrary.utility.UConsole;
import fyfrel.mylibrary.utility.UScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class AppWindow extends JFrame{
    private JPanel panel = new JPanel(new CardLayout());
    private HashMap<String, ArrayList<Object>> componentToGetText = new HashMap<>();

    public AppWindow() {
        this.setTitle("Ma Banque");
        ImageIcon oui = new ImageIcon("src/fyfrel/bank/misc/img/Icon.png");
        this.setIconImage(oui.getImage());
        this.setSize(UScreen.getScreenSize()[0], UScreen.getScreenSize()[1]);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createOpenMenu();
        createRegisterMenu();
        createErrorRegisterMenu();
        createConnectionMenu();

            
        this.add(panel);
        this.openCard("AuthMenu");
        this.setVisible(true);
    }

    private void createOpenMenu() {
        JPanel card = new JPanel();

        JButton login = new JButton("Connexion");
        login.addActionListener(new Connection());
        card.add(login);

        JButton register = new JButton("Créer un Compte");
        register.addActionListener(new Register());
        card.add(register);

        panel.add(card, "AuthMenu");
    }

    private void createRegisterMenu() {
        componentToGetText.put("RegisterMenu" , new ArrayList<>());
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
        componentToGetText.get("RegisterMenu").add(firstName);
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
        componentToGetText.get("RegisterMenu").add(lastName);
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
        componentToGetText.get("RegisterMenu").add(password);
        card.add(password, c);

        JButton register = new JButton("Créer un Compte");
        register.addActionListener(new UserCreation());
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(100, 0, 0, 0);
        card.add(register, c);

        panel.add(card, "RegisterMenu");
    }


    private void createErrorRegisterMenu() {
        JPanel card = new JPanel();

        JLabel error = new JLabel("Vous avez déjà un compte");
        card.add(error);

        JButton login = new JButton("Connexion");
        login.addActionListener(new Connection());
        card.add(login);

        JButton register = new JButton("Créer un Compte");
        register.addActionListener(new Register());
        card.add(register);






        panel.add(card, "AlreadyExist");
    }


    private void createConnectionMenu() {
        componentToGetText.put("ConnectionMenu" , new ArrayList<>());
        JPanel card = new JPanel();
        card.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel title = new JLabel("Connexion utilisateur");
        c.gridx = 0;
        c.gridy = 0;
        card.add(title, c);



        JLabel firstNameLabel = new JLabel("Votre prénom : ");
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(100, 0, 0, 0);
        card.add(firstNameLabel, c);

        JTextField firstName = new JTextField();
        componentToGetText.get("ConnectionMenu").add(firstName);
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
        componentToGetText.get("ConnectionMenu").add(lastName);
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
        componentToGetText.get("ConnectionMenu").add(password);
        card.add(password, c);

        JButton register = new JButton("Se connecter");
        register.addActionListener(new UserConnection());
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(100, 0, 0, 0);
        card.add(register, c);

        panel.add(card, "ConnectionMenu");
    }








    private void openCard(String cardName) {
        CardLayout cl = (CardLayout)(panel.getLayout());
        cl.show(panel, cardName);
    }

    public class Connection implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            openCard("Connection");
        }
    }

    public class Register implements ActionListener {
        @Override
        public  void    actionPerformed(ActionEvent e) {
            openCard("RegisterMenu");
        }
    }

    public class UserCreation implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Object> components = componentToGetText.get("RegisterMenu");
            JTextField firstName = (JTextField) components.get(0);
            JTextField lastName = (JTextField) components.get(1);
            JPasswordField password = (JPasswordField) components.get(2);
            if(Authentication.register(firstName.getText(), lastName.getText(), password.getText())) {
                openCard("AuthMenu");
                return;
            }
            openCard("AlreadyExist");
        }
    }

    public class UserConnection implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Object> components = componentToGetText.get("RegisterMenu");
            JTextField firstName = (JTextField) components.get(0);
            JTextField lastName = (JTextField) components.get(1);
            JPasswordField password = (JPasswordField) components.get(2);
            if(Authentication.connection(firstName.getText(), lastName.getText(), password.getText())) {
                openCard("AppMenu");
                return;
            }
            openCard("ConnectError");
        }
    }
}
