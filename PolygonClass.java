/*
 * Definition of subclass Polygon
 */

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
class PolygonClass extends ShapeClass {

    private int[] xArray;
    private int[] yArray; 
    int num;

    public PolygonClass (int[] xin, int[] yin, int n) {
        xArray = xin.clone();
        yArray = yin.clone();
        num = n;
        setPos(xin[0], yin[0]);
    }

    public boolean checks(Point p) {
        Polygon pol = new Polygon(xArray, yArray, num);
        return pol.contains(p);
    }

    public void draw(Graphics g) {
        g.fillPolygon(xArray, yArray, num);
    }
}
