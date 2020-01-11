package model;

import java.util.List;

public interface OrderDetailDao {
    void insertOrder(OrderDetails orderDetails);

    OrderDetails getOrderDetailsById(int id);

    // Read
    List<OrderDetails> getAllOrderDetails(int id_Order);

    //Update
    void updateOrder(OrderDetails orderDetails);

    //Delete
    void deleteOrder(int id);
}
