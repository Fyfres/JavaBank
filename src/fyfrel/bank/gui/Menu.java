package fyfrel.bank.gui;

import javax.swing.*;

/**
 * Class abstract used for every Menu
 */
public abstract class Menu extends JPanel {
    protected WindowApp window;
    protected String cardName;

    /**
     *
     * @param window AppWindow the frame of the App
     * @param cardName name of the card that'll be in the JPanel in CardLayout
     */
    public Menu(WindowApp window, String cardName) {
        this.window = window;
        this.cardName = cardName;
    }
}
