/*  Canvas.java
 *  Aryan Pandey
 *  
 *  Purpose: Main drawing area of the Program
 */

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Canvas extends JPanel {

    /* Contains a Model object that stores 
     * data relating to all the vehicles
     * in the program */
    private Model model;
    private Color color;

    Canvas (Model m) {
        model = m;
        Color lightBlue = new Color(82, 219, 255);
        color = lightBlue;
    }

    /* draw Callback */ 
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        setBackground(color);
        
        model.drawAll(g);
        //TODO: Add background objects later 

    }
    public void repaintCall(){
        repaint();
    }
    
    public void setBG(Color c) {
        color = c;
    }
}
