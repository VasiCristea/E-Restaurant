package Components;

import javax.swing.*;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FieldsFactory {

    public static JTextField CreateTextField(String text) {

        JTextField textField = new JTextField();

        textField.setHorizontalAlignment(SwingConstants.LEFT);
        textField.setPreferredSize(new Dimension(textField.getWidth(), 37));

        if(textField.getText().length() == 0) {
            textField.setText(text);
            textField.setForeground(new Color(150, 150, 150));
        }

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField.setText("");
                textField.setForeground(new Color(50, 50, 50));
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(textField.getText().length() == 0) {
                    textField.setText(text);
                    textField.setForeground(new Color(150, 150, 150));
                }
            }
        });

        return  textField;
    }
    public static JTextField CreatePasswordField() {

        JPasswordField passwordField = new JPasswordField();

        passwordField.setHorizontalAlignment(SwingConstants.LEFT);
        passwordField.setPreferredSize(new Dimension(passwordField.getWidth(), 37));

        if(passwordField.getText().length() == 0) {
            passwordField.setText("Password");
            passwordField.setForeground(new Color(150, 150, 150));
        }

        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                passwordField.setText("");
                passwordField.setForeground(new Color(50, 50, 50));
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(passwordField.getText().length() == 0) {
                    passwordField.setText("Password");
                    passwordField.setForeground(new Color(150, 150, 150));
                }
            }
        });

        return  passwordField;
    }
}
