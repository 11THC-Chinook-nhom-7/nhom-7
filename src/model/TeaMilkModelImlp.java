package model;

import java.util.List;
import java.util.Vector;

public class TeaMilkModelImlp implements TeaMilkModel{

private List<TableObserver> tableObservers = new Vector<>();

    @Override
    public List<TeaMilk> getAllTeaMilk() {
        TeaMilkDao dao = new TeaMilkDaoImpl();
        return dao.getAllTraSua();
    }

    @Override
    public void addTeaMilk(TeaMilk teaMilk) {
        TeaMilkDao dao = new TeaMilkDaoImpl();
        dao.insertTeaMilk(teaMilk);
        notifyObservers();
    }

    @Override
    public void deleteTeaMilk(int id) {
        TeaMilkDao dao = new TeaMilkDaoImpl();
        dao.deleteTeaMilk(id);
        notifyObservers();
    }

    @Override
    public void registerObserver(TableObserver observer) {
        if (!tableObservers.contains(observer))
            tableObservers.add(observer);
    }

    @Override
    public TeaMilk getTeaMilkbyId(int id) {
        TeaMilkDao dao = new TeaMilkDaoImpl();
        return dao.getTraSuaById(id);
    }

    @Override
    public void updateTeaMilk(TeaMilk teaMilk) {
        TeaMilkDao dao = new TeaMilkDaoImpl();
        dao.updateTeaMilk(teaMilk);
        notifyObservers();
    }

    @Override
    public void unregisterObserver(TableObserver observer) {
        tableObservers.remove(observer);
    }

    private void notifyObservers() {
        List<TeaMilk> teaMilks = getAllTeaMilk();
        for (TableObserver observer: tableObservers) {
            observer.updateTable(teaMilks);
        }
    }
}
