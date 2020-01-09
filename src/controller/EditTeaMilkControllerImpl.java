package controller;

import model.TeaMilk;
import model.TeaMilkModel;
import view.EditTeaMilk;

import javax.swing.*;
import java.awt.*;

public class EditTeaMilkControllerImpl implements EditTeaMilkController {

    private EditTeaMilk view;
    private Component parent;
    private TeaMilkModel model;

    public EditTeaMilkControllerImpl(Component parent, TeaMilkModel model,EditTeaMilk view) {
        this.view = view;
        this.model = model;
        this.parent = parent;

    }

    @Override
    public void EditTeaMilk(TeaMilk teaMilk) {
        view.getTMID().setText(teaMilk.getId()+"");
        view.getPrice().setText(teaMilk.getPrice()+"");
        view.getTxtName().setText(teaMilk.getNameTraSua());
        int option = JOptionPane.showConfirmDialog(parent,
                view.getRootPanel(),
                "Edit TeaMilk",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if(option == JOptionPane.YES_OPTION)
        {
            int id =Integer.parseInt(view.getTMID().getText());
            String Name = view.getTxtName().getText();
            double Price = Double.parseDouble(view.getPrice().getText());
            TeaMilk teaMilk1 = new TeaMilk(id,Name,Price);
            model.updateTeaMilk(teaMilk1);
        }
    }
}
