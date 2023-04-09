package Views;

import Components.ButtonsFactory;
import Components.Colors;
import Components.LabelsFactory;
import Components.PanelsFactory;

import javax.swing.*;
import java.awt.*;

public class Login {

    public Login() {
        InitFrame();
    }

    public JFrame InitFrame() {
        JFrame loginFrame = new JFrame();
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(400,500);
        loginFrame.setVisible(true);
        loginFrame.setLayout(new BorderLayout(90, 50));

        JPanel panel = new JPanel();
        panel.setSize(500, 500);
        panel.setVisible(true);
        panel.setLayout(new GridLayout(3,1));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout(25, 25));

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(4, 1));

        JButton loginButton = ButtonsFactory.CreateButton("Log in", ButtonsFactory.ButtonsTypes.Primary);
        JPanel titlePanel = PanelsFactory.CreatePanel("Login", 0, 0, 383, 44, Colors.LightBlue);
        JLabel titleText = LabelsFactory.CreateLabel("Login", Colors.White);
        JTextField user = new JTextField();
        JPasswordField pass = new JPasswordField();

        loginFrame.add(titlePanel, BorderLayout.NORTH);
        loginFrame.add(panel, BorderLayout.CENTER);
        loginFrame.add(new JPanel(), BorderLayout.SOUTH);
        loginFrame.add(new JPanel(), BorderLayout.WEST);
        loginFrame.add(new JPanel(), BorderLayout.EAST);



        panel.add(textPanel);
        textPanel.add(new JLabel("Username"));
        textPanel.add(user);
        textPanel.add(new JLabel("Password"));
        textPanel.add(pass);
        panel.add(new JPanel());
        panel.add(buttonPanel);
        buttonPanel.add(loginButton, BorderLayout.CENTER);
        buttonPanel.add(new JPanel(), BorderLayout.NORTH);
        buttonPanel.add(new JPanel(), BorderLayout.SOUTH);
        buttonPanel.add(new JPanel(), BorderLayout.EAST);
        buttonPanel.add(new JPanel(), BorderLayout.WEST);
        titlePanel.add(titleText);

        return loginFrame;
    }
}
