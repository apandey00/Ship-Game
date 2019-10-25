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
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JLabel label;
    private int score;

    private Canvas canvas;

    public Model(Vehicle v) {
        boats = new Vector<>();
        boats.add(v);
        currVehicle = 0;

        /* Start timer for animation */
        Timer timer = new Timer(10, this);
        timer.start();

        score = 0;
    }
    public void addLabel(JLabel label) {
        this.label = label;
    }
    protected boolean checkCollision() {
        for (int i = 0; i < boats.size(); i++) {
            for (int j = i + 1; j < boats.size(); j++) {
                if (boats.get(i).collides(boats.get(j).getVehicleBase())) {
                    return true;
                }
            }
        }
        return false;
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
        score++;
        label.setText("Score: " + score);
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
        boats.removeElementAt(i);
    }

    public void setCanvas(Canvas c) {
        canvas = c;
    }

    public void drawAll(Graphics g) {
        for (int i = 0; i < numVehicles(); i++) {
            if (checkBounds(boats.get(i))) {
                if (boats.get(i).getOrientation() == 1) {
                    boats.get(i).setPos((int)screenSize.getWidth(), boats.get(i).getLocation().y);
                }
                else {
                    boats.get(i).setPos(0, boats.get(i).getLocation().y);
                } 
            }

            if (checkCollision()) {
                removeVehicle(currVehicle);
                score = 0;
            }
            if (currVehicle == i) {
                boats.get(i).setColor(Color.RED);
            }
            getVehicles(i).draw(g);
            boats.get(i).setColor(Color.BLACK);
        }
    }
    public void redraw() {
        canvas.repaintCall();
    }

    private boolean checkBounds(Vehicle v) {
        double x = v.getLocation().getX();
        double y = v. getLocation().getY();

        if (x > screenSize.getWidth() || x < 0) {
            return true;
        }
        return false;
    }
}
