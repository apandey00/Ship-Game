/* Shape.java
 * Superclass for all shapes 
 */

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

abstract public class ShapeClass {
    protected int x, y;
    Shape shape;

    public void setPos (int xin, int yin) {
        x = xin; y = yin;
    }

    public boolean checks(Point p) {
        double x = p.getX();
        double y = p.getY();

        if (x < this.x + 25 && x > this.x - 25 )
            if (y < this.y + 25 && y > this.y - 25)
                return true;
        return false;
    }
    public Shape getShape() {
        return shape;
    }
    protected boolean collides(ShapeClass other) {
        return shape.getBounds2D().intersects(other.getShape().getBounds2D());
    }

    /* abstract function */
    protected void draw(Graphics g) {}
 }