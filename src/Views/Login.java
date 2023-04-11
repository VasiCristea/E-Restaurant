package Views;

import Components.*;
import Enums.Constants;

import javax.swing.*;
import java.awt.*;

public class Login {

    public Login() {
        InitFrame();
    }

    private JFrame InitFrame() {
        JFrame mainFrameq = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1200,800);

        JPanel backPanel = new JPanel();
        backPanel.setBackground(new Color(20, 108, 148));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(400, 420));

        JPanel contentPanel = new JPanel();
        contentPanel.setVisible(true);
        contentPanel.setLayout(new GridLayout(2,1));

        JPanel buttonPanel = new JPanel();
//        buttonPanel.setBackground(Color.cyan);

        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new GridLayout(2, 1, 0, 5));
//        dataPanel.setBackground(Color.green);

        JButton loginButton = ButtonsFactory.CreateButton("Log in", Constants.Colors.DarkBlue);
        JPanel titlePanel = PanelsFactory.CreatePanel(Constants.Colors.LightBlue);
        JLabel titleLabel = LabelsFactory.CreateLabel("USER LOGIN", Constants.Colors.White);
        JTextField user = FieldsFactory.CreateTextField("Username");
        JPasswordField pass = (JPasswordField) FieldsFactory.CreatePasswordField();

        titleLabel.setFont(new Font(titleLabel.getFont().getName(), titleLabel.getFont().getStyle(), 15));


        backPanel.add(mainPanel);
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        titlePanel.add(titleLabel);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        dataPanel.add(user);
        dataPanel.add(pass);
        contentPanel.add(dataPanel);
        contentPanel.add(buttonPanel);
        buttonPanel.add(loginButton, BorderLayout.CENTER);

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(70, 130, 50, 130));
        dataPanel.setBorder(BorderFactory.createEmptyBorder(50, 30, 30, 30));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 14, 0));
        backPanel.setBorder(BorderFactory.createEmptyBorder(190, 400, 190, 400));

        mainFrame.add(backPanel);
        mainFrame.setVisible(true);
        return mainFrame;
    }
}
