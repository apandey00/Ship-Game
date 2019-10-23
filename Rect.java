/*
 * Definition of subclass Rect
 */
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.Shape;
class Rect extends ShapeClass {

    private int wid, ht; 
    private int x, y;

    public Rect (int xin, int yin, int widin, int htin) {
        x = xin; y = yin; 
        wid = widin; ht = htin; 
        setPos(xin, yin);
    }

    public void setSize (int widin, int htin) {
        wid = widin; ht = htin; 
    }

    public boolean checks(Point p) {
        Rectangle rect = new Rectangle(x, y, wid, ht);
        return rect.contains(p);
    }

    public void draw(Graphics g) {
        g.drawRect(x, y, wid, ht);
    }
}
