package model;

import java.util.List;

public interface TeaMilkModel  {
    List<TeaMilk> getAllTeaMilk();
    void  addTeaMilk(TeaMilk teaMilk);
    void deleteTeaMilk(int id);
    void registerObserver(TableObserver observer);
    TeaMilk getTeaMilkbyId(int id);
    void updateTeaMilk(TeaMilk teaMilk);
    void unregisterObserver(TableObserver observer);
}
