package view;

import javax.swing.*;

public class NewTeaMilk {
    private JPanel rootPanelNewTeaMilk;
    private JTextField txtName;
    private JTextField txtPrice;

        public JPanel getRootPanel(){return rootPanelNewTeaMilk;}
        public String getName(){return txtName.getText();}
        public double getPrice(){return Double.parseDouble(txtPrice.getText());}

}
