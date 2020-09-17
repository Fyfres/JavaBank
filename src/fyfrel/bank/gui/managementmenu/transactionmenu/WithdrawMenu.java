package fyfrel.bank.gui.managementmenu.transactionmenu;

import fyfrel.bank.datas.clientside.accounts.Account;
import fyfrel.bank.gui.AppWindow;

import javax.swing.*;
import java.util.ArrayList;

public class WithdrawMenu extends JPanel {
    private Account account;
    private AppWindow window;

    public WithdrawMenu(Account account, AppWindow window) {
        this.account = account;
        this.window = window;
        ArrayList error = new ArrayList();
        error.add(false);
    }

    public WithdrawMenu(Account account, AppWindow window, ArrayList<Object> error) {
        this.account = account;
        this.window = window;
    }
}
