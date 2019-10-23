/* Model.java
 * Class that holds all the data for the simulation
 */
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Model implements ActionListener {
    private Vector<Vehicle> boats;
    private int currVehicle;

    private Canvas canvas;

    public Model(Vehicle v) {
        boats = new Vector<>();
        boats.add(v);
        currVehicle = 0;

        /* Start timer for animation */
        Timer timer = new Timer(10, this);
        timer.start();
    }

    public void setSpeed(int s) {
        boats.get(currVehicle).setSpeed(s);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tick();
        canvas.repaint();

    }
    public void doMouse(Point p) {
        for (int i = 0; i < boats.size(); i++) {
            if (boats.get(i).isInside(p)) {
                currVehicle = i;
                break;
            }
        }
    }

    protected void tick() {
        for (int i = 0; i < boats.size(); i++) {
            boats.get(i).changeDisplay();
            boats.get(i).tick();
        }
    }
    public void stopAll() {
        for (int i = 0; i < boats.size(); i++) {
            boats.get(i).stopMotion();
        }
    }
    public void startAll() {
        for (int i = 0; i < boats.size(); i++) {
            boats.get(i).startMotion();
        }
    }

    public void stopCurr()
    {
        boats.get(currVehicle).stopMotion();
    }
    public void startCurr() {
        boats.get(currVehicle).startMotion();
    }
    public void addVehicle(Vehicle v) {
        boats.add(v);
    }

    public Vehicle getVehicles(int i) {
        return boats.elementAt(i); 
    } 

    public int numVehicles() {
        return boats.size();
    }

    public void setCurVehicle(int i) {
        currVehicle = i;
    }

    public int getCurVehicle() {
        return currVehicle;
    }

    public void removeVehicle(int i) {
        // To be implemented 
    }

    public void setCanvas(Canvas c) {
        canvas = c;
    }

    public void drawAll(Graphics g) {
        for (int i = 0; i < numVehicles(); i++) {
            getVehicles(i).draw(g);
        }
    }
    public void redraw() {
        canvas.repaintCall();
    }
}
