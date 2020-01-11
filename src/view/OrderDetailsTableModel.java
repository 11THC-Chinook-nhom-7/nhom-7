package view;

import model.Order;
import model.OrderDetails;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsTableModel extends AbstractTableModel {
    private List<OrderDetails> orderDetailsList = new ArrayList<>();
    private static final String[] COLUMS_NAME = {"ID_Details","ID_Order","ID_Topping"};
    private static final int ID_Details = 0;
    private static final int ID_Order = 1;
    private static final int ID_Topping = 2;
    @Override
    public int getRowCount() {
        return orderDetailsList.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMS_NAME.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMS_NAME[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        OrderDetails orderDetails = orderDetailsList.get(rowIndex);
        if (columnIndex == ID_Details) {
            return orderDetails.getID_Detail();
        }
        if (columnIndex == ID_Order) {
            return orderDetails.getId_Order();
        }
        if (columnIndex == ID_Topping) {
            return orderDetails.getID_topping();
        }
        return null;
    }

    public void updateOrderDetails(List<OrderDetails> orderList1) {
        this.orderDetailsList.clear();
        this.orderDetailsList.addAll(orderList1);
        fireTableDataChanged();
    }
}
