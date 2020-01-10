package model;

import java.util.ArrayList;
import java.util.List;

public class OrderModelIplm implements OrderModel {
    private List<TableObserverNewOrder> tableObserverOrder = new ArrayList<>();
    @Override
    public List<Order> getAllOrders() {
        OrderDao dao = new OrderDaoIplm();
        return dao.getAllOrder();
    }

    @Override
    public void addOrder(Order order) {
        OrderDao dao = new OrderDaoIplm();
        dao.insertOrder(order);
        notifyObservers();
    }

    @Override
    public void deleteOrder(int id) {
        OrderDao dao = new OrderDaoIplm();
        dao.deleteOrder(id);
        notifyObservers();
    }

    @Override
    public void registerObserver(TableObserverNewOrder observer) {
        if (!tableObserverOrder.contains(observer))
            tableObserverOrder.add(observer);
    }

    @Override
    public void updateOrder(Order order) {
        OrderDao dao = new OrderDaoIplm();
        dao.updateOrder(order);
        notifyObservers();
    }

    @Override
    public void unregisterObserver(TableObserver observer) {

    }

    public void notifyObservers() {
        List<Order> orderList = getAllOrders();
        for (TableObserverNewOrder observer: tableObserverOrder) {
            observer.updateTableOrders(orderList);
        }
    }
}
