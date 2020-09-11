package fyfrel.mylibrary.utility;

import java.awt.*;

public class UScreen {
    /**
     * Search the dimensions of the user's screen
     * @return an Array of int that are the Width and Height of the user's screen
     */
    public static int[] getScreenSize() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        return new int[]{dimension.getSize().width, dimension.getSize().height};
    }
}
