package Views;

import Components.*;
import Enums.Constants;

import javax.swing.*;
import java.awt.*;

public class AddWaiter {

    public AddWaiter() {
        InitFrame();
    }

    private JFrame InitFrame() {

        JFrame mainFrame = new JFrame();
        mainFrame.setSize(1200, 800);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel backPanel = new JPanel();
        backPanel.setBackground(Constants.Colors.DarkBlue);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(400, 420));

        JLabel contentPanel = new JLabel();
        contentPanel.setLayout(new GridLayout(2, 1));

        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new GridLayout(4,1,0,5));

        JPanel buttonPanel = new JPanel();

        JPanel titlePanel = PanelsFactory.CreatePanel(Constants.Colors.LightBlue);
        JLabel titleLabel = LabelsFactory.CreateLabel("ADD WAITER ACCOUNT", Constants.Colors.White);
        JTextField firstnameTextField = FieldsFactory.CreateTextField("First name");
        JTextField lastnameTextField = FieldsFactory.CreateTextField("Last name");
        JTextField usernameTextField = FieldsFactory.CreateTextField("Username");
        JPasswordField passwordField = (JPasswordField) FieldsFactory.CreatePasswordField();
        JButton createButton = ButtonsFactory.CreateButton("Create", Constants.Colors.DarkBlue);

        titleLabel.setFont(new Font(titleLabel.getFont().getName(), titleLabel.getFont().getStyle(), 15));

        titlePanel.add(titleLabel);
        buttonPanel.add(createButton);
        dataPanel.add(firstnameTextField);
        dataPanel.add(lastnameTextField);
        dataPanel.add(usernameTextField);
        dataPanel.add(passwordField);
        contentPanel.add(dataPanel);
        contentPanel.add(buttonPanel);
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        backPanel.add(mainPanel);
        mainFrame.add(backPanel);

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(80, 130, 40, 130));
        dataPanel.setBorder(BorderFactory.createEmptyBorder(40, 30, 0, 30));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 14, 0));
        backPanel.setBorder(BorderFactory.createEmptyBorder(190, 400, 190, 400));

        mainFrame.setVisible(true);
        return mainFrame;
    }
}
