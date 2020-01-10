package model;

import java.util.List;

public interface OrderDao {
    void insertOrder(Order order);

    Order getOrderById(int id);

    // Read
    List<Order> getAllOrder();

    //Update
    void updateOrder(Order order);

    //Delete
    void deleteOrder(int id);

}
