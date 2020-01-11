package view;

import Decorator.Beverage;
import controller.*;
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
                Beverage beverage = null;
                onAddNewOrder(beverage);
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

tbOrderList.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            int rowIndex = tbOrderList.getSelectedRow();
            id_Order =Integer.parseInt(orderTableModel.getValueAt(rowIndex,0).toString());
            int id_TeaMilk = Integer.parseInt(orderTableModel.getValueAt(rowIndex,1).toString());
            TeaMilkModel teaMilkModel= new TeaMilkModelImlp();
            TeaMilk teaMilk = teaMilkModel.getTeaMilkbyId(id_TeaMilk);
            //Beverage beverage = new TeaMilk(teaMilk.getId(),teaMilk.getNameTraSua(),teaMilk.getPrice());
            doubleTable(id_Order,teaMilk);

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

    private void onAddNewOrder(Beverage beverage){
        TeaMilkModel model = new TeaMilkModelImlp();
        TeaMilkView teaMilkView = new TeaMilkView(model);
        teaMilkView.SetOrderModel(orderModel);
    }

    private void deleteOrder(int id_Order){
        orderModel.deleteOrder(id_Order);
    }

    private void doubleTable(int ID_Order, TeaMilk teaMilk){
        OrderDetailModel model = new OrderDetailModelIplm();
        TopPingModel topPingModel = new TopPingModelImpl();
        OrderViewController controller = new OrderViewControllerImpl(this,model,topPingModel,new OrderView(topPingModel,model,ID_Order));
        controller.newOrderDetailsShow(ID_Order, teaMilk);
    }
}
