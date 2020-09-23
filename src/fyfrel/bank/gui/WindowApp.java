package fyfrel.bank.gui;

import fyfrel.bank.gui.panels.authmenu.AuthMainMenu;
import fyfrel.bank.gui.panels.authmenu.ConnectionMenu;
import fyfrel.bank.gui.panels.authmenu.RegisterMenu;
import fyfrel.bank.gui.panels.managementmenu.AccountListMenu;
import fyfrel.bank.gui.panels.managementmenu.CustomerListMenu;
import fyfrel.bank.gui.panels.managementmenu.NewAccountMenu;
import fyfrel.bank.gui.panels.MainMenu;
import fyfrel.mylibrary.utility.UScreen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The class at the base of everything
 * The window that'll contain everything to show
 */
public class WindowApp extends JFrame{
    private JPanel panel = new JPanel(new CardLayout());
    private HashMap<String, ArrayList<Object>> componentToGetText = new HashMap<>();

    private ImageIcon appIcon = new ImageIcon("src/fyfrel/bank/misc/img/Icon.png");
    public JPanel getPanel() {
        return panel;
    }
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    public HashMap<String, ArrayList<Object>> getComponentToGetText() {
        return componentToGetText;
    }
    public void setComponentToGetText(HashMap<String, ArrayList<Object>> componentToGetText) {
        this.componentToGetText = componentToGetText;
    }
    public ImageIcon getAppIcon() {
        return appIcon;
    }
    public void setAppIcon(ImageIcon appIcon) {
        this.appIcon = appIcon;
    }


    /**
     * Create the base of the app and the Menus that doesn't need precise information
     */
    public WindowApp() {
        this.setTitle("Ma Banque");
        this.setIconImage(appIcon.getImage());
        this.setSize(UScreen.getScreenSize()[0], UScreen.getScreenSize()[1]);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        AuthMainMenu.createAuthMainMenu(this);
        new RegisterMenu(this);
        ConnectionMenu.createConnectionMenu(this);
        new MainMenu(this);
        NewAccountMenu.createNewAccountMenu(this);
        new AccountListMenu(this);
        new CustomerListMenu(this);


        this.add(panel);
        this.openCard("AuthMenu");
        this.setVisible(true);
    }

    /**
     * Method to show a card by it's name
     * @param cardName String the name of the card
     */
    public void openCard(String cardName) {
        CardLayout cl = (CardLayout)(panel.getLayout());
        cl.show(panel, cardName);
    }
}
