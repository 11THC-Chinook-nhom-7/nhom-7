package controller;

import model.TeaMilk;
import model.TeaMilkModel;
import view.ProductManager;


public class TeaMilkControlerImpl implements TeaMilkControler {

    private ProductManager view;

    public TeaMilkControlerImpl(TeaMilkModel model){
            this.view = new ProductManager(model);
    }


    @Override
    public void ChooseTeaMilk() {

    }
}
