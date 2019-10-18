import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import java.awt.*;
import javax.swing.*;

import javax.swing.JScrollBar;

public class ScrollBar extends JScrollBar implements AdjustmentListener { 

    private Model model;
    public ScrollBar (Model m) {
    setOrientation (HORIZONTAL); 
    setMinimum (0); 
    setMaximum (100); 

    setValue (20); 
    setEnabled(true);

    addAdjustmentListener (this); 

    model = m;
    }

    public void adjustmentValueChanged (AdjustmentEvent event) { 
        System.out.println ("Scrollbar speed: new value = " + getValue()); 
        model.setSpeed(getValue());
    }
}

