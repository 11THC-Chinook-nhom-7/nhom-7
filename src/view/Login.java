package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private JTextField txtUser;
    private JTextField txtPassword;
    private JButton loginButton;
    private JButton cancelButton;
    private JPanel rootPanelLogin;


    public Login() {

        setTitle("Products");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanelLogin);
        setPreferredSize(new Dimension(400, 500));
        pack();

        setVisible(true);



        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtUser.getText();
                //String pass = txtPassword.getText();

                if(name.equals("admin"))
                {
                    JOptionPane.showConfirmDialog(rootPanelLogin,"login thanh cong");
                    Manager manager = new Manager();
                    manager.setVisible(true);

                }
                else
                {
                    JOptionPane.showMessageDialog(rootPanelLogin,"Sai mat khau hoac password");
                }

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
