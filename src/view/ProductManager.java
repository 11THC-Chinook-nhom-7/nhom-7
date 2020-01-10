package view;

import controller.*;
import model.TableObserver;
import model.TeaMilk;
import model.TeaMilkModel;
import model.TopPing;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.TabableView;
import java.awt.*;
import java.awt.event.*;
import java.beans.VetoableChangeListener;import java.util.List;

public class ProductManager extends JFrame implements TableObserver {

    private JPanel rootPanelProduct;
    private JTable table_Products;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton cancelButton;
    private JScrollPane tbl_Product;
    private TeaMilkTableModel teaMilkTableModel;
    private TeaMilkModel model;
    int idSelect = -1;
    public ProductManager(TeaMilkModel model)
    {
        this.model = model;
        this.model.registerObserver(this);
        setTitle("Student Manager");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanelProduct);
        setPreferredSize(new Dimension(400, 500));
        pack();
        setVisible(true);
        teaMilkTableModel = new TeaMilkTableModel();
        table_Products.setModel(teaMilkTableModel);
        List<TeaMilk>teaMilks =this.model.getAllTeaMilk();
        teaMilkTableModel.updateTeaMilks(teaMilks);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAddTeaMilks(e);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDeleteTeaMilk(idSelect);
            }
        });

        table_Products.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int rowIndex = table_Products.getSelectedRow();
                if(rowIndex != -1){
                    idSelect = Integer.parseInt(table_Products.getValueAt(rowIndex, 0).toString());
                }
                System.out.println(idSelect);
            }
        });


        updateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2)
                {
                    TeaMilk teaMilk = new TeaMilk();
                    int rowIndex =table_Products.getSelectedRow();
                    teaMilk.setId(Integer.parseInt(table_Products.getValueAt(rowIndex,0).toString()));
                    teaMilk.setNameTraSua(table_Products.getValueAt(rowIndex,1).toString());
                    teaMilk.setPrice(Double.parseDouble(table_Products.getValueAt(rowIndex,2).toString()));
                    onEditTeaMilk(teaMilk);
                }
            }
        });
    }

    private void  onAddTeaMilks(ActionEvent e)
    {
        NewTeaMilkController controller = new NewTeaMilkControllerImpl(this, model,new NewTeaMilk());
        controller.NewTeaMilk();
    }

    private void onDeleteTeaMilk(int idSelect)
    {
        DeleteTeaMilkController controller = new DeleteTeaMilkControllerImpl();
        if(idSelect != -1)
        {
            int option= JOptionPane.showConfirmDialog(this,
            "Are you sure delete" + idSelect,"Delete TeaMilk",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.PLAIN_MESSAGE);
            if(option == JOptionPane.YES_OPTION)
            {
                controller.DeleteTeaMilk(model,idSelect);
            }
        }
    }

    private void onEditTeaMilk(TeaMilk teaMilk) {
        EditTeaMilkController controller = new EditTeaMilkControllerImpl(this,model,new EditTeaMilk());
        controller.EditTeaMilk(teaMilk);
    }



    @Override
    public void updateTable(List<TeaMilk> teaMilks) {
        teaMilkTableModel.updateTeaMilks(teaMilks);
    }


}
