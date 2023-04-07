package Components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public abstract class ButtonsFactory {
    public static JButton CreateButton(String text, ButtonsTypes type){
        JButton button = new JButton(text);
        switch (type) {
            case Primary -> {
                button.setForeground(new Color(225, 225, 225));
                button.setBackground(new Color(20, 108, 148));
            }
            case Info -> {
                button.setForeground(new Color(225, 225, 225));
                button.setBackground(new Color(23, 183, 178));
            }
            case Danger -> {
                button.setForeground(new Color(225, 225, 225));
                button.setBackground(new Color(126, 30, 10));
            }
        }

        return button;
    }
    public enum ButtonsTypes{
        Primary,
        Danger,
        Info
    }
}
