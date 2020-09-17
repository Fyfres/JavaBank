package fyfrel.bank.gui.commonlistener;

import fyfrel.bank.gui.AppWindow;
import fyfrel.bank.gui.managementmenu.AccountListMenu;
import fyfrel.bank.process.authentication.Authentication;
import fyfrel.mylibrary.utility.UMath;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommonListener {

    public static class FieldNumberVerif implements DocumentListener {
        private JTextField field;
        private Boolean negative;
        private AppWindow window;
        private String cardName;
        private Integer index;

        public FieldNumberVerif(AppWindow window, String cardName, JTextField field, Integer index, Boolean negative) {
            this.window = window;
            this.field = field;
            this.negative = negative;
            this.cardName = cardName;
            this.index = index;
        }



        @Override
        public void insertUpdate(DocumentEvent e) {
            JTextField amount = (JTextField) window.getComponentToGetText().get(cardName).get(index);
            fieldNumberVerif(amount, false);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            return;
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            JTextField amount = (JTextField) window.getComponentToGetText().get(cardName).get(index);
            fieldNumberVerif(amount, false);
        }

        public void fieldNumberVerif(JTextField field, Boolean negative) {
            SwingUtilities.invokeLater(() -> {
                if(!UMath.testStringToDouble(field.getText())
                        || field.getText().substring(field.getText().length() - 1).equals("f")
                        || field.getText().substring(field.getText().length() - 1).equals("d")
                        || field.getText().substring(field.getText().length() - 1).equals("F")
                        || field.getText().substring(field.getText().length() - 1).equals("D")
                ) {
                    if(negative) {
                        if(field.getText().substring(0).equals("-") && field.getText().length() <= 1){
                            return;
                        }
                    }
                    field.setText("0");
                }
                if(negative && Double.parseDouble(field.getText()) > 0){
                    field.setText("0");
                }
            });
        }
    }





    public static class BackToAuthMenu implements ActionListener {
        private AppWindow window;

        public BackToAuthMenu(AppWindow receivedWindow) {
            this.window = receivedWindow;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Authentication.disconnect();
            window.openCard("AuthMenu");
        }
    }

    public static class BackToMainMenu implements ActionListener {
        private AppWindow window;

        public BackToMainMenu(AppWindow receivedWindow) {
            this.window = receivedWindow;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            window.openCard("UserMenu");
        }
    }







    public static class OpenListAccountMenu implements ActionListener {
        private AppWindow window;

        public OpenListAccountMenu(AppWindow window) {
            this.window = window;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JPanel listPanel = (JPanel) window.getComponentToGetText().get("AccountListMenu").get(0);
            listPanel.removeAll();
            AccountListMenu.recreateListWhenReady(listPanel, window);

            window.openCard("AccountListMenu");
        }
    }
}
