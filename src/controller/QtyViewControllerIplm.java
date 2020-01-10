package controller;

import model.Order;
import model.OrderModel;
import model.TeaMilk;
import view.QtyTeaMilk;

import javax.swing.*;
import java.awt.*;

public class QtyViewControllerIplm implements QtyViewController {
    private Component parent;
    private OrderModel model;
    private QtyTeaMilk view;
    public QtyViewControllerIplm(Component parent, OrderModel model, QtyTeaMilk view) {
        this.parent = parent;
        this.model = model;
        this.view = view;
    }
    @Override
    public void newOrder(TeaMilk teaMilk) {
        view.getLbId().setText(teaMilk.getId() +"");
        view.getLbName().setText(teaMilk.getNameTraSua());
        int option = JOptionPane.showConfirmDialog(parent,
                view.getRootPanel(),
                "Qty TeaMilk",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            Order order = new Order();
            order.setID_TeaMilk(teaMilk.getId());
            order.setQty(Integer.parseInt(view.getTxtQty().getText()));
            model.addOrder(order);
        }
    }
}
