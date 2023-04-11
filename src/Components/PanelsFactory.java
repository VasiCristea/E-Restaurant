package Components;
import Enums.Constants;

import javax.swing.*;
import java.awt.*;

public class PanelsFactory {

    public static JPanel CreatePanel(Color color) {
        JPanel panel = new JPanel();

        if (color.equals(Constants.Colors.LightBlue)) {
            panel.setBackground(Constants.Colors.LightBlue);
        }
        return panel;
    }
}

