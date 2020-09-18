package fyfrel.bank.gui;

import javax.swing.*;

public abstract class Menu extends JPanel {
    protected WindowApp window;
    protected String cardName;

    public Menu(WindowApp window, String cardName) {
        this.window = window;
        this.cardName = cardName;
    }
}
