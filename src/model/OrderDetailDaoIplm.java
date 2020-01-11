package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDaoIplm implements OrderDetailDao {

    @Override
    public void insertOrder(OrderDetails orderDetails) {
        Database db = new Database();
        final String SQL_CREATE_OrderDetails = "INSERT INTO tbl_Detail(id_hoadon,ID_topping)" +
                "VALUES(?,?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_CREATE_OrderDetails, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,orderDetails.getId_Order());
            ps.setInt(2,orderDetails.getID_topping());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                orderDetails.setID_Detail(id);
                System.out.println("Inserted " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public OrderDetails getOrderDetailsById(int id) {
        Database db = new Database();
        OrderDetails orderDetails = new OrderDetails();
        final String SQL_Select_OrderById = "SELECT * FROM  WHERE tbl_Detail ID_Detail=?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_Select_OrderById, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                orderDetails.setID_Detail(rs.getInt(1));
                orderDetails.setId_Order(rs.getInt(2));
                orderDetails.setID_topping(rs.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return orderDetails;
    }

    @Override
    public List<OrderDetails> getAllOrderDetails(int id_Order) {
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        Database db = new Database();
        final String SQL_GETAllOrder = "SELECT * FROM tbl_Detail Where id_hoadon=? ";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_GETAllOrder, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id_Order);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setID_Detail(rs.getInt(1));
                orderDetails.setId_Order(rs.getInt(2));
                orderDetails.setID_topping(rs.getInt(3));
                orderDetailsList.add(orderDetails);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        db.close();
        return orderDetailsList;
    }

    @Override
    public void updateOrder(OrderDetails orderDetails) {
        Database db = new Database();
        final  String SQL_UPDATE_OrderDetals= "UPDATE tbl_Detail SET id_hoadon = ?, ID_topping = ?" +
                " WHERE ID_Detail = ?";

        try{
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_OrderDetals,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,orderDetails.getId_Order());
            ps.setInt(2,orderDetails.getID_topping());
            ps.setInt(3,orderDetails.getID_Detail());
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
        final  String SQL_UPDATE_TOPPING = "DELETE FROM tbl_Detail " +
                " WHERE ID_Detail = ?";
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
