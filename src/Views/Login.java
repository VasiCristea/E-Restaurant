package Views;

import Components.ButtonsFactory;

import javax.swing.*;

public class Login {
    JFrame f=new JFrame();//creating instance of JFrame
    JButton b = ButtonsFactory.CreateButton("LOGIN", ButtonsFactory.ButtonsTypes.Primary);

    public Login() {
        b.setBounds(130,100,100, 40);//x axis, y axis, width, height

        f.add(b);//adding button in JFrame

        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
    }
}
