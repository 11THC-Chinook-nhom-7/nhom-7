package controller;

import model.TeaMilk;
import model.TeaMilkModel;
import model.TopPing;
import model.TopPingModel;
import view.EditTeaMilk;
import view.EditTopPing;

import javax.swing.*;
import java.awt.*;

public class EditTopPingControllerImpl implements EditTopPingController {
    private Component parent;
    private TopPingModel model;
    private EditTopPing view;


    public EditTopPingControllerImpl(Component parent,TopPingModel model,EditTopPing view) {
        this.parent = parent;
        this.model = model;
        this.view = view;

    }

    @Override
    public void EditTopPing(TopPing topPing) {
        view.getTPID().setText(topPing.getID_topping()+"");
        view.getPrice().setText(topPing.getPrice()+"");
        view.getTxtName().setText(topPing.getName());
        int option = JOptionPane.showConfirmDialog(parent,
                view.getRootPanel(),
                "Edit TeaMilk",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if(option == JOptionPane.YES_OPTION)
        {
            int id =Integer.parseInt(view.getTPID().getText());
            String Name = view.getTxtName().getText();
            double Price = Double.parseDouble(view.getPrice().getText());
            TopPing topPing1 = new TopPing(id,Name,Price);
            model.updateTopPing(topPing1);
        }
    }
}
