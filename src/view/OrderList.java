package view;

import controller.NewTeaMilkController;
import controller.NewTeaMilkControllerImpl;
import controller.NewToppingController;
import controller.NewToppingControllerImpl;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class OrderList extends JFrame implements TableObserverNewOrder {
    private JTable tbOrderList;
    private JButton btnRemove;
    private JButton btnNewOrder;
    private JPanel rootPanel;
    private NewOrderTableModel orderTableModel;
    private OrderModel orderModel;
    private int id_Order=-1;

    public OrderList(OrderModel Ordermodel) {
        this.orderModel = Ordermodel;
        this.orderModel.registerObserver(this);
        setTitle("Employee Manager");
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(400, 500));
        pack();
        setVisible(true);

        orderTableModel = new NewOrderTableModel();
        orderTableModel.updateOrder(orderModel.getAllOrders());
        tbOrderList.setModel(orderTableModel);
        btnNewOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAddNewOrder();
            }
        });

        tbOrderList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int rowIndex = tbOrderList.getSelectedRow();
                    id_Order =Integer.parseInt(orderTableModel.getValueAt(rowIndex,1).toString());
                }
            }
        });

        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(id_Order > -1){
                    deleteOrder(id_Order);
                }
            }
        });
    }

    public JTable getTbOrderList() {
        return tbOrderList;
    }

    public JButton getBtnRemove() {
        return btnRemove;
    }

    public JButton getBtnNewOrder() {
        return btnNewOrder;
    }

    @Override
    public void updateTableOrders(List<Order> orders) {
        orderTableModel.updateOrder(orders);
    }

    private void onAddNewOrder(){
        TeaMilkModel model = new TeaMilkModelImlp();
        TeaMilkView teaMilkView = new TeaMilkView(model);
        teaMilkView.SetOrderModel(orderModel);
    }

    private void deleteOrder(int id_Order){
        orderModel.deleteOrder(id_Order);
    }
}
