package model;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TeaMilkDaoImpl implements TeaMilkDao {

    public TeaMilkDaoImpl() {
        Database db = new Database();
        String SQL_CREATE_TRASUA_TABLE = "CREATE TABLE IF NOT EXISTS tbl_TraSua (\n"
                + "    ID integer PRIMARY KEY,\n"
                + "    name text NOT NULL,\n"
                + "    price money NOT NULL,\n"
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
    public void insertTraSua(TeaMilk teaMilk) {

    }

    @Override
    public TeaMilk getTraSuaById(int id) {
        return null;
    }

    @Override
    public List<TeaMilk> getAllTraSua() {
        return null;
    }

    @Override
    public void updateEmployee(TeaMilk teaMilk) {

    }

    @Override
    public void deleteEmloyee(TeaMilk id) {

    }
}
