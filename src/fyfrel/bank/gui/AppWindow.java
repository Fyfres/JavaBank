package fyfrel.bank.gui;

import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.datas.clientside.accounts.CurrentAccount;
import fyfrel.bank.datas.clientside.accounts.SavingAccount;
import fyfrel.bank.gui.authmenu.AuthMainMenu;
import fyfrel.bank.gui.authmenu.ConnectionMenu;
import fyfrel.bank.gui.authmenu.RegisterMenu;
import fyfrel.bank.gui.commonlistener.CommonListener;
import fyfrel.bank.gui.managementmenu.NewAccountMenu;
import fyfrel.bank.process.authentication.Authentication;
import fyfrel.mylibrary.utility.UMath;
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


    public AppWindow() {
        this.setTitle("Ma Banque");
        this.setIconImage(appIcon.getImage());
        this.setSize(UScreen.getScreenSize()[0], UScreen.getScreenSize()[1]);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        AuthMainMenu.createAuthMainMenu(this);
        new RegisterMenu(this);
        ConnectionMenu.createConnectionMenu(this);
        new MainMenu(this);
        NewAccountMenu.createNewAccountMenu(this);


        this.add(panel);
        this.openCard("AuthMenu");
        this.setVisible(true);
    }

    public void openCard(String cardName) {
        CardLayout cl = (CardLayout)(panel.getLayout());
        cl.show(panel, cardName);
    }
}
