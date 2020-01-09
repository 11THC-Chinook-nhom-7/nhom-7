package controller;

import model.TeaMilk;
import model.TeaMilkModel;
import view.NewTeaMilk;
import view.ProductManager;

import javax.swing.*;
import java.awt.*;

public class NewTeaMilkControllerImpl implements NewTeaMilkController {

    private Component parent;
    private TeaMilkModel model;
    private NewTeaMilk view;

    public NewTeaMilkControllerImpl(ProductManager parent, TeaMilkModel model, NewTeaMilk view) {
            this.parent = parent;
            this.model = model;
            this.view = view;
    }


    @Override
    public void NewTeaMilk() {
        int option = JOptionPane.showConfirmDialog(parent,
                view.getRootPanel(),
                "New TeaMilk",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if(option == JOptionPane.YES_OPTION)
        {
            String Name = view.getName();
            double Price = view.getPrice();

            TeaMilk teaMilk = new TeaMilk();
            teaMilk.setNameTraSua(Name);
            teaMilk.setPrice(Price);
            model.addTeaMilk(teaMilk);
        }

    }
}
