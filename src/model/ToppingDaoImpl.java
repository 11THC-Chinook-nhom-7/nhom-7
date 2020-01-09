package model;

import org.sqlite.core.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

public class ToppingDaoImpl implements ToppingDao {
    @Override
    public void insertTopping(TopPing topPing) {
        Database db = new Database();
        final String SQL_CREATE_TOPPING = "INSERT INTO tbl_TopPing(name,price)" +
                "VALUES(?,?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_CREATE_TOPPING, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,topPing.getName());
            ps.setDouble(2,topPing.getPrice());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                topPing.setID_topping(id);
                System.out.println("Inserted " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.close();
    }

    @Override
    public TopPing getTopPingById(int id) {
        return null;
    }

    @Override
    public List<TopPing> getAllTopPing() {
        List<TopPing> topPings = new Vector<>();
        Database db = new Database();

        final String SQL_GETALLTOPPING = "SELECT * FROM tbl_TopPing";
        try {
            Statement statement = db.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(SQL_GETALLTOPPING);
            while (rs.next())
            {
                int id = rs.getInt(1);
                String Name = rs.getString(2);
                double Price = rs.getDouble(3);
                TopPing topPing = new TopPing(id,Name,Price);
                topPings.add(topPing);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        db.close();
        return topPings;
    }

    @Override
    public void updateTopping(TopPing topPing) {
        Database db = new Database();
        final  String SQL_UPDATE_TOPPING = "UPDATE tbl_TopPing SET name = ? , price = ? WHERE ID_topping = ?";
        try{
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_TOPPING,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,topPing.getName());
            ps.setDouble(2,topPing.getPrice());
            ps.setInt(3,topPing.getID_topping());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void deleteTopping(int id) {
        Database db = new Database();
        String SQL_DELETE_TOPPING = "DELETE FROM tbl_TopPing WHERE ID_topping = ?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE_TOPPING);
            ps.setInt(1,id);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        db.close();
    }
}
