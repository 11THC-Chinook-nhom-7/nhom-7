package model;

import java.util.List;

public interface ToppingDao {
    void insertTopping( TopPing topPing);
    TopPing getTopPingById(int id);
    // Read
    List<TopPing> getAllTopPing();
    //Update
    void updateTopping(TopPing topPing);
    //Delete
    void deleteTopping(TopPing id);
}
