package view;

import javax.swing.*;
import java.awt.*;

public class OrderView extends  JFrame{
    private JRadioButton rdogiam0duong;
    private JRadioButton rdogiam30duong;
    private JRadioButton rdogiam50duong;
    private JRadioButton rdogiam70duong;
    private JRadioButton rdothem30duong;
    private JRadioButton rdogiam0da;
    private JRadioButton rdogiam30da;
    private JRadioButton rdogiam50da;
    private JRadioButton rdogiam70da;
    private JPanel rootPanel;
    private JCheckBox trânChâuĐườngĐenCheckBox;

    public  OrderView()
    {
        setTitle("Order Manager");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(400, 500));
        pack();
        setVisible(true);
    }
}
