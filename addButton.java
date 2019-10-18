/* addButton.java */
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addButton extends JButton implements ActionListener{
    private String actionMessage;
    private Model model;
    private ComboBox combo;
    private TextField tfCol;
    private TextField tfRow;

    public addButton (String label, String msg, Model m, ComboBox Combo,
                      TextField tf1, TextField tf2){
        
        setText(label);
        addActionListener(this);

        actionMessage = msg;
        model = m;
        combo = Combo;
        tfCol = tf1;
        tfRow = tf2;
    }

    public void actionPerformed(ActionEvent e){
        System.out.println(actionMessage);
        String colS = tfCol.getText();
        String rowS = tfRow.getText();
        
        tfCol.setText("");
        tfRow.setText("");
        
        int col = Integer.parseInt(colS);
        
        int row = Integer. parseInt(rowS);

        SailBoat v = new SailBoat(col, row);
        model.addVehicle(v);
        combo.addShip();
        model.redraw();
    }
}

