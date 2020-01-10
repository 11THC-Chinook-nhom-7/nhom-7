package view;

import model.TeaMilk;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class TeaMilkViewTableModel extends AbstractTableModel {

    private List<TeaMilk> teaMilks = new Vector<>();
    private static final String[] COLUMS_NAME = {"NAME", "Price"};
    private static final int NAME = 0;
    private static final int PRICE = 1;


    @Override
    public int getRowCount() {
        return teaMilks.size();
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
        TeaMilk teaMilk = teaMilks.get(rowIndex);
          if(columnIndex == NAME) {
            return teaMilk.getNameTraSua();
        } else if(columnIndex == PRICE) {
            return  teaMilk.getPrice();
        }
        return null;
    }

    public void updateTeaMilks(List<TeaMilk> teaMilks) {
        this.teaMilks.clear();
        this.teaMilks.addAll(teaMilks);
        fireTableDataChanged();
    }




}
