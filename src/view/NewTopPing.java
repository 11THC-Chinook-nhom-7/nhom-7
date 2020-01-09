package view;

import javax.swing.*;

public class NewTopPing {
    private JPanel rootAddTopPing;
    private JTextField txtName;
    private JTextField txtPrice;


    public JPanel getRootAddTopPing(){return rootAddTopPing;}
    public String getTopPingName(){return txtName.getText();}
    public double getTopPingPrice(){return Double.parseDouble(txtPrice.getText());}


}
