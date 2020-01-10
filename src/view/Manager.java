package view;

import model.TeaMilkModel;
import model.TeaMilkModelImlp;
import model.TopPingModel;
import model.TopPingModelImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manager extends JFrame {


    public Manager() {

        setTitle("TopPing Manager");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanelManager);
        setPreferredSize(new Dimension(400, 500));
        pack();
        setVisible(true);

        btnProductManager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeaMilkModel model = new TeaMilkModelImlp();
                ProductManager productManager = new ProductManager(model);
                productManager.setVisible(true);
                Manager.this.dispose();

            }
        });
        topPingManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TopPingModel model  = new TopPingModelImpl();
                ToppingManager toppingManager = new ToppingManager(model);
                Manager.this.dispose();

            }
        });
    }




    private JButton topPingManagerButton;
    private JButton btnProductManager;
    private JPanel rootPanelManager;

}
