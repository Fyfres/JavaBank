package fyfrel.bank.gui.managementmenu;

import fyfrel.bank.gui.AppWindow;

import javax.swing.*;
import java.awt.*;

public class AccountListMenu extends JPanel{
    private AppWindow window;

    private void AccountListMenu(AppWindow receivedWindow) {
        this.window = receivedWindow;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel interestLabel = new JLabel("Liste de vos Comptes en Banque :");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(50, 0, 0, 0);
        this.add(interestLabel, c);

        JPanel list = new JPanel();
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(50, 0, 0, 0);
        this.add(list, c);


        window.getPanel().add(this, "AccountListMenu");
    }
}
