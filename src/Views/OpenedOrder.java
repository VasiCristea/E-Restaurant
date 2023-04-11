package Views;

import javax.swing.*;

public class OpenedOrder {

    public OpenedOrder() {
        InitFrame();
    }

    private JFrame InitFrame() {
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1200,800);

        return mainFrame;
    }
}
