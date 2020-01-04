package model;

public class TopPing {
    private int ID_topping;
    private  String name;
    private double price;
    private String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public TopPing(){}

    public TopPing(int ID_topping, String name, double price,String size) {
        this.ID_topping = ID_topping;
        this.name = name;
        this.price = price;
        this.size = size;
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
}
