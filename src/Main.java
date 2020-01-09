import controller.*;
import model.*;
import view.Login;
import view.OrderView;
import view.ProductManager;


public class Main {

    public static void main(String[] args) {
        Database database = new Database();
       // OrderView orderView = new OrderView();
      //  TeaMilkModel model = new TeaMilkModelImlp();
      //  TeaMilkControler controler = new TeaMilkControlerImpl(model);
        TopPingModel model = new TopPingModelImpl();
        TopPingController controller = new TopPingControllerImpl(model);
    }
}
