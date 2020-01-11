package model;

import java.util.List;

public interface TopPingModel {
    List<TopPing> getAllTopPing();
    void addTopPing(TopPing topPing);
    void deleteTopPing(int id);
    TopPing getToppingById(int id);
    void registerObserver(TableObserverTopPing observer);
    void updateTopPing(TopPing topPing);
    void unregisterObserver(TableObserverTopPing observer);
}
