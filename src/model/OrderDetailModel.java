package model;

import java.util.List;

public interface OrderDetailModel {
    List<OrderDetails> getAllOrderDetails(int id_Order);
    void addOrderDetails(OrderDetails orderDetails);
    void updateOrderDetails(OrderDetails orderDetails);
    void deleteOrderDetails(int id);
    void registerObserver(TableObserverOrderDetails observer);
    void unregisterObserver(TableObserverOrderDetails observer);
}
