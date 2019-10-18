/*
 * Definition of subclass Rect
 */
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
class Rect extends Shape {

    private int wid, ht; 
    private int x, y;

    public Rect (int xin, int yin, int widin, int htin) {
        x = xin; y = yin; 
        wid = widin; ht = htin; 
    }

    public void setSize (int widin, int htin) {
        wid = widin; ht = htin; 
    }

    public void draw(Graphics g) {
        g.drawRect(x, y, wid, ht);
    }
}
