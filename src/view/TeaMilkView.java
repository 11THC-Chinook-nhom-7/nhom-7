package view;

import controller.NewTeaMilkController;
import controller.NewTeaMilkControllerImpl;
import model.TableObserver;
import model.TeaMilk;
import model.TeaMilkModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TeaMilkView extends JFrame implements TableObserver {
    private JPanel rootPanelTeaMilkView;
    private JTextField txtSearch;
    private JButton btnSearch;
    private JTable table_TeaMlikView;
    private JButton btnManager;
    private TeaMilkTableModel teaMilkTableModel;
    private TeaMilkModel model;

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
    }

    @Override
    public void updateTable(List<TeaMilk> teaMilks) {
        teaMilkTableModel.updateTeaMilks(teaMilks);
    }
}
