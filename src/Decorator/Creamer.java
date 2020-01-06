package Decorator;

import model.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Creamer extends TraSuaDecorator {
    String creaSize="";
    final  String ToppingName = "Creamer";
    protected Creamer(CompomentTraSua trasua, String creamSize) {
        super(trasua);
        this.creaSize = creamSize;
    }

    @Override
    public double cost() {
        return trasua.cost() + price();
    }

    @Override
    public double price() {
        Database db = new Database();
        double price = 0;
        final String SQL_SelectPrice_EMPLOYEE = "Select * from tbl_TopPing Where name=? AND size=? ";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_SelectPrice_EMPLOYEE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ToppingName);
            ps.setString(2, creaSize);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                price = rs.getDouble(4);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.close();
        return price;
    }

    @Override
    public String size() {
        return creaSize;
    }
}
