package model;

import org.sqlite.core.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ToppingDaoImpl implements ToppingDao {
    @Override
    public void insertTopping(TopPing topPing) {
        Database db = new Database();
        final String SQL_CREATE_Topping = "INSERT INTO tbl_TopPing(name, size, price)" +
                "VALUES(?,?,?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_CREATE_Topping, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, topPing.getName());
            ps.setString(2,topPing.getSize());
            ps.setDouble(3,topPing.getPrice());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                topPing.setID_topping(id);
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
        return null;
    }

    @Override
    public void updateTopping(TopPing topPing) {

    }

    @Override
    public void deleteTopping(TopPing id) {

    }
}
