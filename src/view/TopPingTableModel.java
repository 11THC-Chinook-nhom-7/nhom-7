package view;

import model.TopPing;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class TopPingTableModel extends AbstractTableModel {

    private List<TopPing> topPings = new Vector<>();

    private static final String []COLUMS_NAME = {"ID" ,"NAME" ,"PRICE"};

    private static final int ID = 0;
    private static final int NAME = 1;
    private static final int PRICE = 2;

    @Override
    public int getRowCount() {
        return topPings.size();
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

        TopPing topPing = topPings.get(rowIndex);
        if(columnIndex == ID){
            return topPing.getID_topping();
        } else if(columnIndex == NAME) {
            return topPing.getName();
        } else if(columnIndex == PRICE){
            return topPing.getPrice();
        }
        return null;
    }

   public void updateTopPing(List<TopPing> topPings){
        this.topPings.clear();
        this.topPings.addAll(topPings);
        fireTableDataChanged();
   }


}
