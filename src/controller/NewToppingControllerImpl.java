package controller;

import model.TopPing;
import model.TopPingModel;
import view.NewTopPing;
import view.ToppingManager;

import javax.swing.*;
import java.awt.*;

public class NewToppingControllerImpl implements NewToppingController {

    private Component parent;
    private TopPingModel model;
    private NewTopPing view;

    public NewToppingControllerImpl(ToppingManager parent, TopPingModel model, NewTopPing view) {
        this.parent = parent;
        this.model = model;
        this.view = view;
    }

    @Override
    public void NewTopPing() {
        int option = JOptionPane.showConfirmDialog(parent,
        view.getRootAddTopPing(),
        "Add TopPing",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.PLAIN_MESSAGE);

        if(option == JOptionPane.YES_OPTION)
        {
            String Name = view.getTopPingName();
            double Price =  view.getTopPingPrice();

            TopPing topPing = new TopPing();
            topPing.setName(Name);
            topPing.setPrice(Price);
            model.addTopPing(topPing);
        }
    }
}
