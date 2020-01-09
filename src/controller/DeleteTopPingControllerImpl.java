package controller;

import model.TopPing;
import model.TopPingModel;

public class DeleteTopPingControllerImpl implements  DeleteTopPingController{

    @Override
    public void DeleteTopPing(TopPingModel model, int id) {
        model.deleteTopPing(id);
    }
}
