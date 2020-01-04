package model;

import java.util.List;

public interface TraSuaDao  {

void insertTrSua(TraSua traSua);
    TraSua getTraSuaById(int id);
    // Read
    List<TraSua> getAllTraSua();

    //Update
    void updateEmployee(TraSua traSua);
    //Delete
    void deleteEmloyee(TraSua id);

}
