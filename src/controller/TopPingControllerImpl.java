package controller;

import model.TopPingModel;
import view.ToppingManager;

public class TopPingControllerImpl implements TopPingController {
    private ToppingManager view;

    public TopPingControllerImpl(TopPingModel model)
    {
        this.view = new ToppingManager(model);
    }
}
