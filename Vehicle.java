/* Vehicle.java 
 * Superclass for vehicles used in the simulation
 */

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Vector;
import java.awt.event.*;

abstract public class Vehicle {
    /* UP and DOWN states currently disabled */
    //protected static final int UP = 0;
    protected static final int LEFT = 1;
    //protected static final int DOWN = 2;
    protected static final int RIGHT = 3;

    protected int initialX;
    protected int initialY;

    protected int currX;
    protected int currY;

    protected int orientation;

    protected Vector<ShapeClass> components;
    protected Color c;

    protected boolean inMotion;
    protected int speed = 10;

    /* draws out all the shapes that make up the vehicle */
    protected void draw(Graphics g) {
        g.setColor(c);    
        for (int i = 0; i < components.size(); i++) {
            (components.elementAt(i)).draw(g);
        }
    }

    /* sets speed */
    // rethink better way to handle speed ratios
    public void setSpeed(int s) {
        speed = s / 2;
    }
    
    public Boolean isInside(Point p) {
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).checks(p)) {
                return true;
            }
        }
            return false;
    }
    /* Updates current locations every tick according to speed */
    public void tick() {
        if (inMotion && orientation == RIGHT) {
            currX = currX + speed / 10;
        } else if (inMotion && orientation == LEFT) {
            currX = currX - speed / 10;
        }
    }
    protected void setColor(Color c) {
        this.c = c;
    }
    protected void stopMotion() {
        inMotion = false;
    }
    protected void startMotion() {
        inMotion = true;
    }
    public boolean isInMotion() {
        return inMotion;
    }
    protected void rotateLeft()
    {
        orientation = LEFT;
        changeDisplay();
    }
    protected void rotateRight() 
    {
        orientation = RIGHT;
        changeDisplay();
    }

    /* abstract function overridden by subclasses */
    protected void changeDisplay() {}
}