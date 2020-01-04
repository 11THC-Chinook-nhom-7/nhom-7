package model;

import java.util.List;

public interface TeaMilkDao {

void insertTraSua(TeaMilk teaMilk);
    TeaMilk getTraSuaById(int id);
    // Read
    List<TeaMilk> getAllTraSua();

    //Update
    void updateEmployee(TeaMilk teaMilk);
    //Delete
    void deleteEmloyee(TeaMilk id);

}
