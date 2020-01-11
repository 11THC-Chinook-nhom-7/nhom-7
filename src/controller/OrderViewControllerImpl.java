package controller;

import Decorator.Beverage;
import model.*;
import view.OrderDetailsTableModel;
import view.OrderView;
import view.TeaMilkTableModel;

import javax.swing.*;
import java.awt.*;

public class OrderViewControllerImpl implements OrderViewController{
    private Component parent;
    private OrderDetailModel model;
    private TopPingModel topPingModel;
    private OrderView view;
    public OrderViewControllerImpl(Component parent, OrderDetailModel model, TopPingModel tpmodel, OrderView view ){
        this.parent = parent;
        this.model = model;
        this.view = view;
        this.topPingModel = tpmodel;
    }
    @Override
    public void newOrderDetailsShow(int ID_Order, TeaMilk teaMilk) {
        int option = JOptionPane.showConfirmDialog(parent,
                view.getRootPane(),
                "New OrderDetails",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {

            double price = teaMilk.getPrice();
            for (OrderDetails orderDetails: model.getAllOrderDetails(ID_Order)) {
                    TopPing topPing = topPingModel.getToppingById(orderDetails.getID_topping());
                    price = price + topPing.getPrice();
            }
            teaMilk.setPrice(price);
            System.out.println(price);

        }
    }
}
