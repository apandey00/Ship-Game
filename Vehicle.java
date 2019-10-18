/* Vehicle.java 
 * Superclass for vehicles used in the simulation
 */

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Vector;

abstract public class Vehicle {
    protected static final int UP = 0;
    protected static final int LEFT = 1;
    protected static final int DOWN = 2;
    protected static final int RIGHT = 3;

    protected int initialX;
    protected int initialY;

    protected int currX;
    protected int currY;

    protected int orientation;

    protected Vector<Shape> components;

    protected Color c;
    protected boolean inMotion;
    protected int speed = 10;

    protected void draw(Graphics g) {
        g.setColor(c);    
        for (int i = 0; i < components.size(); i++) {
            (components.elementAt(i)).draw(g);
        }
    }

    public void setSpeed(int s) {
        speed = s / 2;
    }
    
    public void tick() {
        if (inMotion && orientation == RIGHT)
            currX = currX + speed / 10;
        else if (inMotion && orientation == LEFT) 
            currX = currX - speed / 10;
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

    }
    protected void rotateRight() 
    {

    }

    protected void changeDisplay() {}
}