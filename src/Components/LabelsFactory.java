package Components;

import javax.swing.*;
import java.awt.*;

public abstract class LabelsFactory {

    public static JLabel CreateLabel(String text, Colors color) {
        JLabel label = new JLabel(text);
        switch (color) {
            case White -> label.setForeground(new Color(225, 225, 225));
            case Black -> label.setForeground(new Color(0, 0, 0));
        }
        return label;
    }
}
