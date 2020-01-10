package view;

import model.Order;
import model.TeaMilk;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class NewOrderTableModel extends AbstractTableModel {
    private List<Order> orderList = new ArrayList<>();
    private static final String[] COLUMS_NAME = {"ID", "ID_TeaMilk", "Price", "Qty", "Total", "Note"};
    private static final int ID = 0;
    private static final int ID_TeaMilk = 1;
    private static final int PRICE = 2;
    private static final int Qty = 3;
    private static final int TOTAL = 4;
    private static final int NOTE = 5;

    @Override
    public int getRowCount() {
        return orderList.size();
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
        Order order = orderList.get(rowIndex);
        if (columnIndex == ID) {
            return order.getId_Order();
        }
        if (columnIndex == ID_TeaMilk) {
            return order.getID_TeaMilk();
        }
        if (columnIndex == PRICE) {
            return order.getPrice();
        }
        if (columnIndex == Qty) {
            return order.getQty();
        }
        if (columnIndex == TOTAL) {
            return order.getTotal();
        }
        if (columnIndex == NOTE) {
            return order.getNote();
        }
        return null;
    }

    public void updateOrder(List<Order> orderList1) {
        this.orderList.clear();
        this.orderList.addAll(orderList1);
        fireTableDataChanged();
    }
}
