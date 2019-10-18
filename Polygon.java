/*
 * Definition of subclass Polygon
 */

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
class Polygon extends Shape {

    private int[] xArray;
    private int[] yArray; 
    int num;

    public Polygon (int[] xin, int[] yin, int n) {
        xArray = xin.clone();
        yArray = yin.clone();
        num = n;
    }

    public void draw(Graphics g) {
        g.fillPolygon(xArray, yArray, num);
    }
}
