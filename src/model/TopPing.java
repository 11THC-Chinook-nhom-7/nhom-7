package model;

import Decorator.Beverage;
import Decorator.ToppingCodiment;

public class TopPing extends ToppingCodiment {
    Beverage beverage;
    private int ID_topping;
    private String name;
    private double price;

    public TopPing(){}

    public TopPing(int ID_topping, String name, double price) {
        this.ID_topping = ID_topping;
        this.name = name;
        this.price = price;
    }
    public TopPing(Beverage beverage,int ID_topping, String name, double price){
        this.ID_topping = ID_topping;
        this.name = name;
        this.price = price;
        this.beverage = beverage;
    }

    public TopPing(TopPing topPing){
        this.ID_topping = topPing.getID_topping();
        this.name = topPing.getName();
        this.price = topPing.getPrice();
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

    public int getID_topping() {
        return ID_topping;
    }

    public void setID_topping(int ID_topping) {
        this.ID_topping = ID_topping;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + getName();
    }

    @Override
    public double cost() {
        return price + beverage.cost();
    }
}
