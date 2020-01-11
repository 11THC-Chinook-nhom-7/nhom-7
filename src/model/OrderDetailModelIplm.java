package model;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailModelIplm implements OrderDetailModel {
    int id_Oder;
    private List<TableObserverOrderDetails> tableObservers = new ArrayList<>();
    @Override
    public List<OrderDetails> getAllOrderDetails(int id_Order) {
        this.id_Oder = id_Order;
        OrderDetailDao dao = new OrderDetailDaoIplm();
        return dao.getAllOrderDetails(id_Order);
    }

    @Override
    public void addOrderDetails(OrderDetails orderDetails) {
        OrderDetailDao dao = new OrderDetailDaoIplm();
        dao.insertOrder(orderDetails);
        notifyObservers();
    }

    @Override
    public void updateOrderDetails(OrderDetails orderDetails) {
        OrderDetailDao dao = new OrderDetailDaoIplm();
        dao.updateOrder(orderDetails);
        notifyObservers();
    }

    @Override
    public void deleteOrderDetails(int id) {
        OrderDetailDao dao = new OrderDetailDaoIplm();
        dao.deleteOrder(id);
        notifyObservers();
    }

    @Override
    public void registerObserver(TableObserverOrderDetails observer) {
        if (!tableObservers.contains(observer))
            tableObservers.add(observer);
    }

    @Override
    public void unregisterObserver(TableObserverOrderDetails observer) {

    }
    public void notifyObservers() {
        List<OrderDetails> orderDetailsList = getAllOrderDetails(id_Oder);
        for (TableObserverOrderDetails observer: tableObservers) {
            observer.updateTable(orderDetailsList);
        }
    }
}
