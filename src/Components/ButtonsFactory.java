package Components;

import Enums.Constants;

import javax.swing.*;
import java.awt.*;

public abstract class ButtonsFactory {
    public static JButton CreateButton(String text, Color color){
        JButton button = new JButton(text);

        if (color.equals(Constants.Colors.DarkBlue)) {
            button.setForeground(Constants.Colors.White);
            button.setBackground(Constants.Colors.DarkBlue);
        } else if (color.equals(Constants.Colors.LightBlue)) {
            button.setForeground(Constants.Colors.White);
            button.setBackground(Constants.Colors.LightBlue);
        } else if (color.equals(Constants.Colors.Yellow)) {
            button.setForeground(Constants.Colors.Black);
            button.setBackground(Constants.Colors.Yellow);
        } else if (color.equals(Constants.Colors.White)) {
            button.setForeground(Constants.Colors.Black);
            button.setBackground(Constants.Colors.White);
        }

        button.setPreferredSize(new Dimension(200, 37));

        return button;
    }

}
