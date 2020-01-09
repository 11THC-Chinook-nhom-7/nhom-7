package controller;

import model.TeaMilk;
import model.TeaMilkModel;

public class DeleteTeaMilkControllerImpl implements DeleteTeaMilkController {

    @Override
    public void DeleteTeaMilk(TeaMilkModel model, int id) {
        model.deleteTeaMilk(id);
    }
}
