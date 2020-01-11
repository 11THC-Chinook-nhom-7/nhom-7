package view;

import Decorator.Beverage;
import controller.NewTeaMilkController;
import controller.NewTeaMilkControllerImpl;
import controller.QtyViewController;
import controller.QtyViewControllerIplm;
import model.*;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class TeaMilkView extends JFrame implements TableObserver {
    private JPanel rootPanelTeaMilkView;
    private JTextField txtSearch;
    private JButton btnSearch;
    private JTable table_TeaMlikView;
    private JButton btnManager;
    private TeaMilkTableModel teaMilkTableModel;
    private TeaMilkModel model;
    private OrderModel orderModel;


    public TeaMilkView(TeaMilkModel model){
        this.model = model;
        this.model.registerObserver(this);
        setTitle("TeaMilk View");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanelTeaMilkView);
        setPreferredSize(new Dimension(400, 500));
        pack();
        setVisible(true);
        teaMilkTableModel = new TeaMilkTableModel();
        table_TeaMlikView.setModel(teaMilkTableModel);
        List<TeaMilk> teaMilks =this.model.getAllTeaMilk();
        teaMilkTableModel.updateTeaMilks(teaMilks);
        btnManager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manager manager =new Manager();
                manager.setVisible(true);
                TeaMilkView.this.dispose();
            }
        });
        table_TeaMlikView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int rowIndex = table_TeaMlikView.getSelectedRow();
                    TeaMilk teaMilk = new TeaMilk();
                    teaMilk.setId(Integer.parseInt(teaMilkTableModel.getValueAt(rowIndex,0).toString()));
                    teaMilk.setNameTraSua(teaMilkTableModel.getValueAt(rowIndex,1).toString());
                    teaMilk.setPrice(Double.parseDouble(teaMilkTableModel.getValueAt(rowIndex,2).toString()));
                    Beverage beverage = new TeaMilk(teaMilk.getId(),teaMilk.getNameTraSua(),teaMilk.getPrice());
                    SelectTeaMilk(teaMilk, orderModel);
                }
            }
        });

        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                TableRowSorter<TableModel>rowSorter = new TableRowSorter<>(table_TeaMlikView.getModel());
                String text = txtSearch.getText();
                if(text.trim().length()==0)
                {
                    rowSorter.setRowFilter(null);
                }
                else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text));
                }
                table_TeaMlikView.setRowSorter(rowSorter);
            }
        });
    }

    @Override
    public void updateTable(List<TeaMilk> teaMilks) {
        teaMilkTableModel.updateTeaMilks(teaMilks);
    }

    private void SelectTeaMilk(TeaMilk teaMilk, OrderModel model1){
        QtyViewController controller = new QtyViewControllerIplm(this,model1,new QtyTeaMilk());
        controller.newOrder(teaMilk);
    }

    public void SetOrderModel(OrderModel model){
        this.orderModel = model;
    }
}
