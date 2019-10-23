/*  Canvas.java
 *  Aryan Pandey
 *  
 *  Purpose: Main drawing area of the Program
 */

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Canvas extends JPanel implements MouseListener {

    /* Contains a Model object that stores 
     * data relating to all the vehicles
     * in the program */
    private Model model;
    private Color color;

    Canvas (Model m) {
        model = m;
        Color lightBlue = new Color(82, 219, 255);
        color = lightBlue;
        addMouseListener(this);
    }

    /* draw Callback */ 
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        setBackground(color);
        
        model.drawAll(g);
        //TODO: Add background objects later 

    }
    public void mouseClicked (MouseEvent event) {
        model.doMouse(event.getPoint());
    }
    public void repaintCall(){
        repaint();
    }
    
    public void setBG(Color c) {
        color = c;
    }
     public void mousePressed (MouseEvent event) {}
    public void mouseReleased (MouseEvent event) {}
    public void mouseEntered (MouseEvent event) {}
    public void mouseExited (MouseEvent event) {}
}
