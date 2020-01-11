package model;

import Decorator.Beverage;

public class TeaMilk extends Beverage {
 private int id;
 private String nameTraSua;
 private double price;


    public TeaMilk(){
    }

    public TeaMilk(int id, String nameTraSua, double price)
    {
        this.id = id;
        this.nameTraSua = nameTraSua;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTraSua() {
        return nameTraSua;
    }

    public void setNameTraSua(String nameTraSua) {
        this.nameTraSua = nameTraSua;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double cost() {
        return getPrice();
    }

    @Override
    public String getDescription() {
        return getNameTraSua();
    }
}
