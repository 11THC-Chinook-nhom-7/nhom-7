package model;

import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

public class TeaMilkDaoImpl implements TeaMilkDao {

    public TeaMilkDaoImpl() {
        Database db = new Database();
        String SQL_CREATE_TRASUA_TABLE = "CREATE TABLE IF NOT EXISTS tbl_TraSua (\n"
                + "    ID integer PRIMARY KEY,\n"
                + "    name text NOT NULL,\n"
                + "    price money NOT NULL\n"
                + ");";

        String SQL_CREATE_TOPPING_TABLE = "CREATE TABLE IF NOT EXISTS tbl_TopPing (\n"
                + "    ID_topping integer PRIMARY KEY,\n"
                + "    name text NOT NULL,\n"
                + "    price money NOT NULL\n"
                + ");";


        String SQL_CREATE_HOADON_TABLE = "CREATE TABLE IF NOT EXISTS tbl_HOADON (\n"
                + "    id_hoadon  integer PRIMARY KEY,\n"
                + "    ID_TeaMilk integer ,\n"
                + "    price money NOT NULL,\n"
                + "    qty integer NOT NULL, \n"
                + "    total money NOT NULL, \n"
                + "    note text  \n"
                + ");";

        String SQL_CREATE_DETAIL_TABLE = "CREATE TABLE IF NOT EXISTS tbl_Detail (\n"
                + "    ID_Detail integer PRIMARY KEY,\n"
                + "    id_hoadon integer NOT NULL,\n"
                + "    ID_topping integer NOT NULL \n"
                + ");";

        try {
            Statement statement = db.getConnection().createStatement();
            statement.execute(SQL_CREATE_TRASUA_TABLE);
            statement.execute(SQL_CREATE_TOPPING_TABLE);
            statement.execute(SQL_CREATE_HOADON_TABLE);
            statement.execute(SQL_CREATE_DETAIL_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertTeaMilk(TeaMilk teaMilk) {
        Database db = new Database();
        final String SQL_CREATE_TEAMILK = "INSERT INTO tbl_TraSua(name,price)" + "VALUES(?,?)";

        try
        {
            PreparedStatement ps =db.getConnection().prepareStatement(SQL_CREATE_TEAMILK,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,teaMilk.getNameTraSua());
            ps.setDouble(2,teaMilk.getPrice());
            ps.executeUpdate();
            ResultSet rs =ps.getGeneratedKeys();
            if(rs.next())
            {
                int id = rs.getInt(1);
                teaMilk.setId(id);
                System.out.println("Inserted id " + id);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public TeaMilk getTraSuaById(int id) {
        return null;
    }

    @Override
    public List<TeaMilk> getAllTraSua() {
        List<TeaMilk> teaMilks = new Vector<>();
        Database db = new Database();
        final String SQL_SELECT_ALL_TEAMILKS = "SELECT * FROM tbl_TraSua";
        try
        {
            Statement statement =db.getConnection().createStatement();
            ResultSet rs =statement.executeQuery(SQL_SELECT_ALL_TEAMILKS);
            while (rs.next())
            {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);

                TeaMilk teaMilk = new TeaMilk(id,name,price);
                    teaMilks.add(teaMilk);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        db.close();
        return teaMilks;
    }

    @Override
    public void updateTeaMilk(TeaMilk teaMilk) {
        Database db = new Database();
        final String SQL_UPDATE_TEAMILK = "UPDATE tbl_TraSua SET name = ?,price = ? WHERE ID = ? ";

        try{
            PreparedStatement ps  = db.getConnection().prepareStatement(SQL_UPDATE_TEAMILK,Statement.RETURN_GENERATED_KEYS);
           ps.setString(1,teaMilk.getNameTraSua());
           ps.setDouble(2,teaMilk.getPrice());
           ps.setInt(3,teaMilk.getId());
           ps.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void deleteTeaMilk(int id) {
        Database db = new Database();
        String SQL_DELETE_TEAMILK = "DELETE FROM tbl_TraSua WHERE ID = ?";
        try
        {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE_TEAMILK);
            ps.setInt(1,id);
            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        db.close();
    }
}
