package model;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TraSuaDaoImpl implements TraSuaDao {

    public TraSuaDaoImpl()
    {
        Database db = new Database();
        String SQL_CREATE_TRASUA_TABLE = "CREATE TABLE IF NOT EXISTS tbl_TraSua (\n"
                + "    ID integer PRIMARY KEY,\n"
                + "    nameTraSua text NOT NULL,\n"
                + "    price money NOT NULL,\n"
                + "    qty integer NOT NULL \n"
                + ");";

        try
        {
            Statement statement =db.getConnection().createStatement();
            statement.execute(SQL_CREATE_TRASUA_TABLE);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void insertTrSua(TraSua traSua) {

    }

    @Override
    public TraSua getTraSuaById(int id) {
        return null;
    }

    @Override
    public List<TraSua> getAllTraSua() {
        return null;
    }

    @Override
    public void updateEmployee(TraSua traSua) {

    }

    @Override
    public void deleteEmloyee(TraSua id) {

    }
}
