package model;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TraSuaDaoImpl implements TraSuaDao {

    public TraSuaDaoImpl() {
        Database db = new Database();
        String SQL_CREATE_TRASUA_TABLE = "CREATE TABLE IF NOT EXISTS tbl_TraSua (\n"
                + "    ID integer PRIMARY KEY,\n"
                + "    name text NOT NULL,\n"
                + "    price money NOT NULL,\n"
                + "    size text  NOT NULL,\n"
                + "    quality integer NOT NULL \n"
                + ");";

        String SQL_CREATE_TOPPING_TABLE = "CREATE TABLE IF NOT EXISTS tbl_TopPing (\n"
                + "    ID_topping integer PRIMARY KEY,\n"
                + "    name text NOT NULL,\n"
                + "    price money NOT NULL,\n"
                + "    quality integer NOT NULL \n"
                + ");";


        String SQL_CREATE_HOADON_TABLE = "CREATE TABLE IF NOT EXISTS tbl_HOADON (\n"
                + "    id_hoadon  integer PRIMARY KEY,\n"
                + "    ID integer ,\n"
                + "    nameTraSua text NOT NULL,\n"
                + "    size text NOT NULL,\n"
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
        } catch (SQLException e) {
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
