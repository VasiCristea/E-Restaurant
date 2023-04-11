package Components;

import Enums.Constants;

import javax.swing.*;
import java.awt.*;

public abstract class LabelsFactory {

    public static JLabel CreateLabel(String text, Color color) {
        JLabel label = new JLabel(text);
        if (color.equals(Constants.Colors.White)) {
            label.setForeground(Constants.Colors.White);
        } else if (color.equals(Constants.Colors.Black)) {
            label.setForeground(Constants.Colors.Black);
        }
        return label;
    }
}
