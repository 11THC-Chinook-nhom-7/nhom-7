package model;

import java.util.List;

public interface OrderModel {
    List<Order> getAllOrders();
    void  addOrder(Order order);
    void deleteOrder(int id);
    void registerObserver(TableObserverNewOrder observer);
    void updateOrder(Order order);
    void unregisterObserver(TableObserver observer);
}
