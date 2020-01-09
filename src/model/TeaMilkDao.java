package model;

import java.util.List;

public interface TeaMilkDao {

void insertTeaMilk(TeaMilk teaMilk);
    TeaMilk getTraSuaById(int id);
    // Read
    List<TeaMilk> getAllTraSua();

    //Update
    void updateTeaMilk(TeaMilk teaMilk);
    //Delete
    void deleteTeaMilk(int id);

}
