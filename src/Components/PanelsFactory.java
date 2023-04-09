package Components;
import javax.swing.*;
import java.awt.*;

public class PanelsFactory {

    public static JPanel CreatePanel(String text, int x, int y, int width, int height, Colors color) {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, width, height);


        switch (color){
            case LightBlue -> {
                panel.setForeground(new Color(225, 225, 225));
                panel.setBackground(new Color(25, 167, 206));
            }
        }
        return panel;
    }
}

