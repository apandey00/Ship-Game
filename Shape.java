/* Shape.java
 * Superclass for all shapes 
 */

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

abstract public class Shape {
    protected int x, y;

    public void setPos (int xin, int yin) {
        x = xin; y = yin;
    }

    /* abstract function */
    protected void draw(Graphics g) {}
 }