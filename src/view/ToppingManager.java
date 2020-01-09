package view;

import controller.*;
import model.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultTreeCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

public class ToppingManager extends JFrame implements TableObserverTopPing {
    private JTable table_TopPing;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JPanel rootPanelTopping;
    private JScrollPane tbl_Topping;
    private TopPingTableModel topPingTableModel;
    private TopPingModel model;
    int idSelect = -1;

    public ToppingManager(TopPingModel model) {
        this.model = model;
        this.model.registerObserver(this);
        setTitle("Student Manager");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanelTopping);
        setPreferredSize(new Dimension(400, 500));
        pack();
        setVisible(true);
        topPingTableModel = new TopPingTableModel();
        table_TopPing.setModel(topPingTableModel);
        List<TopPing> topPings = this.model.getAllTopPing();
        topPingTableModel.updateTopPing(topPings);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAddTopPing();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDeleteTopPing(idSelect);
            }
        });

        table_TopPing.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int rowIndex = table_TopPing.getSelectedRow();
                if(rowIndex != -1){
                    idSelect = Integer.parseInt(table_TopPing.getValueAt(rowIndex, 0).toString());
                }
                System.out.println(idSelect);
            }
        });


        updateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2)
                {
                    TopPing topPing = new TopPing();
                    int rowIndex =table_TopPing.getSelectedRow();
                    topPing.setID_topping(Integer.parseInt(table_TopPing.getValueAt(rowIndex,0).toString()));
                    topPing.setName(table_TopPing.getValueAt(rowIndex,1).toString());
                    topPing.setPrice(Double.parseDouble(table_TopPing.getValueAt(rowIndex,2).toString()));
                    onEditTopPing(topPing);
                }
            }
        });
    }

   private void onAddTopPing(){
       NewToppingController controller = new NewToppingControllerImpl(this,model,new NewTopPing());
       controller.NewTopPing();
    }

   private void onDeleteTopPing(int idSelect){
       DeleteTopPingController controller = new DeleteTopPingControllerImpl();
       if(idSelect != -1)
       {
           int option= JOptionPane.showConfirmDialog(this,
                   "Are you sure delete" + idSelect,"Delete TeaMilk",
                   JOptionPane.YES_NO_OPTION,
                   JOptionPane.PLAIN_MESSAGE);
           if(option == JOptionPane.YES_OPTION)
           {
               controller.DeleteTopPing(model,idSelect);
           }
       }
   }

    private void onEditTopPing(TopPing topPing) {
        EditTopPingController controller = new EditTopPingControllerImpl(this,model,new EditTopPing());
        controller.EditTopPing(topPing);
    }


    @Override
    public void updateTableTopPing(List<TopPing> topPings) {
        topPingTableModel.updateTopPing(topPings);
    }
}
