package model;

public class Order {
    private int Id_Order;
    private int ID_TeaMilk;
    private double price;
    private int qty;
    private double total;
    private String note;

    public Order() {
        note = "";
    }

    public Order(int Id_Order, int ID_TeaMilk, double price, int qty, double total, String note) {
        this.Id_Order = Id_Order;
        this.ID_TeaMilk = ID_TeaMilk;
        this.price = price;
        this.qty = qty;
        this.total = total;
        this.note = note;
    }

    public int getId_Order() {
        return Id_Order;
    }

    public void setId_Order(int id_Order) {
        this.Id_Order = id_Order;
    }

    public int getID_TeaMilk() {
        return ID_TeaMilk;
    }

    public void setID_TeaMilk(int ID_TeaMilk) {
        this.ID_TeaMilk = ID_TeaMilk;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
