package view;

import model.TopPing;
import model.TopPingModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class OrderView extends  JFrame{
    private JRadioButton rdogiam0duong;
    private JRadioButton rdogiam30duong;
    private JRadioButton rdogiam50duong;
    private JRadioButton rdogiam70duong;
    private JRadioButton rdogiam0da;
    private JRadioButton rdogiam30da;
    private JRadioButton rdogiam50da;
    private JRadioButton rdogiam70da;
    private JPanel rootPanel;
    private TopPingModel topPingModel;
    private JComboBox cbTopping;
    private JButton removeButton;
    private JButton addButton;
    private JTable tbDetails;

    public  OrderView(TopPingModel topPingModel)
    {
        this.topPingModel = topPingModel;
        List<TopPing> topPings = this.topPingModel.getAllTopPing();
        for(TopPing topPing : topPings){
            this.cbTopping.addItem(topPing.getName());
        }
        setTitle("Order Manager");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(400, 500));
        pack();
        setVisible(true);
    }
}
