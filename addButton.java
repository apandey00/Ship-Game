/* addButton.java 
 * Handles adding new instances of vehicles to the simulation
 */
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
    private ToggleButton sail;
    private ToggleButton speed;

    // Need to restructure
    public addButton (String label, String msg, Model m, ComboBox Combo,
                      TextField tf1, TextField tf2, ToggleButton sail,
                      ToggleButton speed){
        
        setText(label);
        addActionListener(this);

        actionMessage = msg;
        model = m;
        combo = Combo;
        tfCol = tf1;
        tfRow = tf2;
        this.sail = sail;
        this.speed = speed;
    }

    public void actionPerformed(ActionEvent e){
        System.out.println(actionMessage);
        String colS = tfCol.getText();
        String rowS = tfRow.getText();
        
        /* default values */
        int col = 100;
        int row = 100;

        /* validate input */
        if (isNumeric(colS) && isNumeric(rowS)) {
            col = Integer.parseInt(colS);
            row = Integer. parseInt(rowS);
        }

        /* reset textfields */
        tfCol.setText("");
        tfRow.setText("");

        Vehicle v;
        if (sail.isSelected()) {
            v = new SailBoat(col, row);
        }
        else {
            v = new SpeedBoat(col, row);
        }
        model.addVehicle(v);
        combo.addShip();
        model.redraw();
    }

    /* function to validate input */
    private boolean isNumeric(String strNum) {
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException | NullPointerException id) {
        return false;
    }
    return true;
}
}

