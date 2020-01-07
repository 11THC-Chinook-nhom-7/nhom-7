package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TraSua extends  JFrame{
    private JPanel rootPanel;
    private JScrollPane rootPanelMain;
    private JTable table_Trasua;
    private JTextField txtTimKiem;
    private JButton managerButton;

    public TraSua()
    {
        setTitle("Product");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(400, 500));
        pack();
        setVisible(true);
        table_Trasua.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });


        managerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manager manager = new Manager();
                manager.setVisible(true);
            }
        });
    }
    private void onSelectTraSua(ActionEvent e)
    {

    }

}
