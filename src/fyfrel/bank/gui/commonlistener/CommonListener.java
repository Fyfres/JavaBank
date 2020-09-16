package fyfrel.bank.gui.commonlistener;

import fyfrel.bank.gui.AppWindow;
import fyfrel.bank.process.authentication.Authentication;
import fyfrel.mylibrary.utility.UMath;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommonListener {

    public static void fieldNumberVerif(JTextField field, Boolean negative) {
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
}
