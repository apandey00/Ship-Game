/* SpeedBoat.java
 * Subclass of Vehicle
 */

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Vector;

public class SpeedBoat extends Vehicle {

    SpeedBoat (int x, int y) {
        components = new Vector<>();

        initialX = x;
        initialY = y;
        currX = x;
        currY = y;

        int xBase[] = {x, x + 25, x + 75, x + 100};
        int yBase[] = {y, y + 25, y + 25, y};

        Polygon base = new Polygon(xBase, yBase, 4);
        components.add(base);

        Rect engine = new Rect(x + 10, y - 10, 10, 10);
        components.add(engine);

        c = Color.BLACK;
        orientation = RIGHT;
        inMotion = true;
    }


    protected void rotateLeft(){
        if (orientation != 3){
            orientation++;
        }
        else {
            orientation = 0;
        }
        changeDisplay();
    }

    protected void rotateRight(){
        if (orientation != 0){
            orientation--;
        }
        else {
            orientation = 3;
        }
        changeDisplay();
    }

    protected void changeDisplay(){
        components.clear();
        switch(orientation){

        case UP:
        
        // TODO: Change hardcoded data to ratios 
        // Find better way to change state when rotating 

        /* shift by 12 to center image */
        currX = currX + 12;
        int xUp[] = {currX + 25, currX + 25, currX + 50 , currX + 50};
        int yUp[] = {currY + 50, currY - 50, currY - 25, currY + 25};
       
        Polygon baseUp = new Polygon(xUp, yUp, 4);
        components.add(baseUp);
        
        int xsailUp[] = {currX - 18, currX + 12 , currX + 12};
        int ysailUp[] = {currY, currY, currY - 20,}; 

        Polygon sailUp = new Polygon(xsailUp, ysailUp, 3);
        components.add(sailUp);

        Rect mastUp = new Rect(currX - 18, currY , 45, 5);
        components.add(mastUp);

        /* Undo shift */
        currX = currX - 12;
        break;

        case DOWN:
        /* shift by 12 to center image */
        currX = currX + 12;
        int xDown[] = {currX + 25, currX + 25, currX , currX };
        int yDown[] = {currY + 50, currY - 50, currY - 25, currY + 25};
       
        Polygon baseDown = new Polygon(xDown, yDown, 4);
        components.add(baseDown);
        
        int xsailDown[] = {currX + 65, currX + 35 , currX + 35};
        int ysailDown[] = {currY + 5, currY + 5, currY + 25,}; 

        Polygon sailDown = new Polygon(xsailDown, ysailDown, 3);
        components.add(sailDown);

        Rect mastDown = new Rect(currX + 24, currY , 40, 5);
        components.add(mastDown);

        /* Undo shift */
        currX = currX - 12;
        
        break;

        case LEFT: 
        int xLeft[] = {currX, currX + 25, currX + 75, currX + 100};
        int yLeft[] = {currY, currY + 25, currY + 25, currY};

        Polygon baseLeft = new Polygon(xLeft, yLeft, 4);
        components.add(baseLeft);

        Rect engineLeft = new Rect(currX + 80, currY - 10, 10, 10);
        components.add(engineLeft);
        break;

        case RIGHT:
        int xBase[] = {currX, currX + 25, currX + 75, currX + 100};
        int yBase[] = {currY, currY + 25, currY + 25, currY};

        Polygon base = new Polygon(xBase, yBase, 4);
        components.add(base);

        Rect engine = new Rect(currX + 10, currY - 10, 10, 10);
        components.add(engine);
        break;
        }
    }
}
