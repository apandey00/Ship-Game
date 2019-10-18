/* ComboBox.java
 * Keeps track of ships
 * and switches control
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ComboBox extends JComboBox<String> implements ItemListener {
    private Model data;
    private int num;
    private ScrollBar scBar;

    public ComboBox (String[] comboStrings, Model m, ScrollBar scBar) {
    for (int i = 0; i < comboStrings.length; i++) {
        addItem (comboStrings[i]); 
    }
    data = m;
    num = comboStrings.length;
    this.scBar = scBar;
    setSelectedItem (comboStrings[0]); 
    addItemListener (this);
    }
    public void itemStateChanged (ItemEvent e) { 
        if (e.getStateChange()==ItemEvent.SELECTED) { 
            System.out.println ("Combo: " + e.getItem()); 
            String str = e.getItem().toString();
            
            int i = Integer.valueOf(str.substring(5));
            data.setCurVehicle(i - 1);
            if ((data.getVehicles(data.getCurVehicle())).isInMotion()) {
                scBar.setEnabled(true);
            }
            else {
                scBar.setEnabled(false);
            }
        }
    }

    public void addShip() {
        num++;
        addItem("Ship " + (num));
    }
}
