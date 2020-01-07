package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manager extends JFrame {


    public Manager() {

        setTitle("Product");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanelManager);
        setPreferredSize(new Dimension(400, 500));
        pack();
        setVisible(true);

        btnProductManager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });
    }




    private JButton topPingManagerButton;
    private JButton btnProductManager;
    private JPanel rootPanelManager;

}
