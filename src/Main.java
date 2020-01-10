import model.*;
import view.OrderList;
import view.OrderView;
import view.TeaMilkView;

import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        Database database = new Database();
       // OrderView orderView = new OrderView();
        TeaMilkModel model = new TeaMilkModelImlp();
      //  TeaMilkControler controler = new TeaMilkControlerImpl(model);
      //  TopPingModel model = new TopPingModelImpl();
        //TopPingController controller = new TopPingControllerImpl(model);
        //TeaMilkView teaMilkView = new TeaMilkView(model);

        JFrame frame = new OrderView(new TopPingModelImpl());

        JFrame frame1 = new OrderList(new OrderModelIplm());
    }
}
