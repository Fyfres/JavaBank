import fyfrel.bank.datas.bankside.Bank;
import fyfrel.bank.gui.WindowApp;

public class Index {
    /**
     * Launch the app
     * @param args String[]
     */
    public static void main(String[] args) {
        Bank.init();
        WindowApp window = new WindowApp();
    }
}
