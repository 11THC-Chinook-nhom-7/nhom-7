package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class OrderView extends JFrame implements TableObserverOrderDetails {
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
    private OrderDetailModel orderDetailModel;
    private OrderDetailsTableModel orderDetailsTableModel;
    private int Id_Details;

    public OrderView(TopPingModel topPingModel, OrderDetailModel orderDetailModel, int idOder) {
        this.topPingModel = topPingModel;
        List<TopPing> topPings = this.topPingModel.getAllTopPing();
        for (TopPing topPing : topPings) {
            this.cbTopping.addItem(topPing.getName());
        }

        this.orderDetailModel = orderDetailModel;
        this.orderDetailModel.registerObserver(this);

        setTitle("Order Manager");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(400, 500));
        pack();
        //setVisible(true);

        orderDetailsTableModel = new OrderDetailsTableModel();
        orderDetailsTableModel.updateOrderDetails(orderDetailModel.getAllOrderDetails(idOder));
        tbDetails.setModel(orderDetailsTableModel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexCombobox = cbTopping.getSelectedIndex();
                TopPing topPing = topPings.get(indexCombobox);
                OrderDetails orderDetail = new OrderDetails();
                orderDetail.setId_Order(idOder);
                orderDetail.setID_topping(topPing.getID_topping());
                orderDetailModel.addOrderDetails(orderDetail);
            }
        });
        tbDetails.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int rowIndex = tbDetails.getSelectedRow();
                    Id_Details = Integer.parseInt(orderDetailsTableModel.getValueAt(rowIndex, 0).toString());
                }
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteDetails();
            }
        });
    }

    @Override
    public void updateTable(List<OrderDetails> orderDetailsList) {
        orderDetailsTableModel.updateOrderDetails(orderDetailsList);
    }

    private void DeleteDetails() {
        orderDetailModel.deleteOrderDetails(Id_Details);
    }

}
