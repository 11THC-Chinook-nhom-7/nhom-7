package model;

import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoIplm implements OrderDao {

    @Override
    public void insertOrder(Order order) {
        Database db = new Database();
        final String SQL_CREATE_Order = "INSERT INTO tbl_HOADON(ID_TeaMilk,price,qty,total,note)" +
                "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_CREATE_Order, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,order.getID_TeaMilk());
            ps.setDouble(2,order.getPrice());
            ps.setInt(3,order.getQty());
            ps.setDouble(4,order.getTotal());
            ps.setString(5,order.getNote());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                order.setId_Order(id);
                System.out.println("Inserted " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public Order getOrderById(int id) {
        Database db = new Database();
        Order order = null;
        final String SQL_Select_OrderById = "SELECT * FROM tbl_HOADON WHERE  id_hoadon=?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_Select_OrderById, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idOrder= rs.getInt(1);
                int  ID_TeaMilk= rs.getInt(2);
                double price  = rs.getDouble(3);
                int qty = rs.getInt(4);
                double total = rs.getDouble(5);
                String note = rs.getString(6);
                order = new Order(idOrder,ID_TeaMilk,price,qty,total,note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return order;
    }

    @Override
    public List<Order> getAllOrder() {
        List<Order> orderList = new ArrayList<>();
        Database db = new Database();
        final String SQL_GETAllOrder = "SELECT * FROM tbl_HOADON";
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(SQL_GETAllOrder);
            while (rs.next())
            {
                int idOrder= rs.getInt(1);
                int  ID_TeaMilk= rs.getInt(2);
                double price  = rs.getDouble(3);
                int qty = rs.getInt(4);
                double total = rs.getDouble(5);
                String note = rs.getString(6);
                Order order = new Order(idOrder,ID_TeaMilk,price,qty,total,note);
                orderList.add(order);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        db.close();
        return orderList;
    }

    @Override
    public void updateOrder(Order order) {
        Database db = new Database();
        final  String SQL_UPDATE_TOPPING = "UPDATE tbl_HOADON SET ID_TeaMilk = ? , price = ?, qty = ?, total = ?, note = ?" +
                " WHERE id_hoadon = ?";
        try{
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_TOPPING,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,order.getID_TeaMilk());
            ps.setDouble(2,order.getPrice());
            ps.setInt(3,order.getQty());
            ps.setDouble(4,order.getTotal());
            ps.setString(5,order.getNote());
            ps.setInt(6,order.getId_Order());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void deleteOrder(int id) {
        Database db = new Database();
        final  String SQL_UPDATE_TOPPING = "DELETE FROM tbl_HOADON " +
                " WHERE id_hoadon = ?";
        try{
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_TOPPING,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        db.close();
    }
}
