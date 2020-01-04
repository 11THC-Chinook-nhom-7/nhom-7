package model;

public class TraSua  {
 private int id;
 private String nameTraSua;
 private double price;
 private int qty;

    public  TraSua(){}

    public TraSua(int id,String nameTraSua,double price, int qty)
    {
        this.id = id;
        this.nameTraSua = nameTraSua;
        this.price = price;
        this.qty = qty;

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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
