package model;

import java.util.List;
import java.util.Vector;

public class TopPingModelImpl implements TopPingModel {

    private List<TableObserverTopPing> tableObserverTopPings = new Vector<>();
    @Override
    public List<TopPing> getAllTopPing() {
        ToppingDao dao = new ToppingDaoImpl();
        return dao.getAllTopPing();
    }

    @Override
    public void addTopPing(TopPing topPing) {
        ToppingDao dao = new ToppingDaoImpl();
        dao.insertTopping(topPing);
        notifyObservers();
    }

    @Override
    public void deleteTopPing(int id) {
        ToppingDao dao = new ToppingDaoImpl();
        dao.deleteTopping(id);
        notifyObservers();
    }

    @Override
    public void registerObserver(TableObserverTopPing observer) {
      if(!tableObserverTopPings.contains(observer));
        tableObserverTopPings.add(observer);
    }

    @Override
    public void unregisterObserver(TableObserverTopPing observer) {
        tableObserverTopPings.remove(observer);
    }

    @Override
    public void updateTopPing(TopPing topPing) {
        ToppingDao dao = new ToppingDaoImpl();
        dao.updateTopping(topPing);
        notifyObservers();
    }


    private void notifyObservers() {
        List<TopPing> topPings = getAllTopPing();
        for (TableObserverTopPing observer: tableObserverTopPings) {
            observer.updateTableTopPing(topPings);
        }
    }
}
