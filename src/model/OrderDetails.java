package model;

public class OrderDetails {
    private int ID_Detail;
    private int Id_Order;
    private int ID_topping;

    public OrderDetails() {
    }

    public OrderDetails(int ID_Detail, int id_Order, int ID_topping) {
        this.ID_Detail = ID_Detail;
        Id_Order = id_Order;
        this.ID_topping = ID_topping;
    }

    public int getID_Detail() {
        return ID_Detail;
    }

    public void setID_Detail(int ID_Detail) {
        this.ID_Detail = ID_Detail;
    }

    public int getId_Order() {
        return Id_Order;
    }

    public void setId_Order(int id_Order) {
        Id_Order = id_Order;
    }

    public int getID_topping() {
        return ID_topping;
    }

    public void setID_topping(int ID_topping) {
        this.ID_topping = ID_topping;
    }
}
