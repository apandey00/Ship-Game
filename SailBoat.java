/* SailBoat.java
 * Subclass of Vehicle
 * TODO: Re-implement UP and down states to handle 
 *       vertical motion instead 
 */

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Vector;

public class SailBoat extends Vehicle {

    SailBoat (int x, int y) {
        components = new Vector<>();

        initialX = x;
        initialY = y;
        currX = x;
        currY = y;

        int xBase[] = {x, x + 25, x + 75, x + 100};
        int yBase[] = {y, y + 25, y + 25, y};

        Polygon base = new Polygon(xBase, yBase, 4);
        components.add(base);
        
        int xSail[] = {x + 50, x + 50, x + 70};
        int ySail[] = {y - 40, y - 10, y - 10,}; 

        Polygon sail = new Polygon(xSail, ySail, 3);
        components.add(sail);

        Rect mast = new Rect(x + 45, y - 40, 5, 40);
        components.add(mast);

        c = Color.BLACK;
        orientation = RIGHT;
        inMotion = true;
    }

    protected void changeDisplay(){
        components.clear();
        switch(orientation){

        /* Up and Down states currently disabled because it looks clunky
         * Code will be refactored to react to vertical motion instead when 
         * implemented 
         */

        /*
        case UP:
        
        // TODO: Change hardcoded data to ratios 
        // Find better way to change state when rotating 

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

        currX = currX - 12;
        break;

        case DOWN:
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

        currX = currX - 12;
        
        break;
        */

        case LEFT: 
        int xLeft[] = {currX, currX + 25, currX + 75, currX + 100};
        int yLeft[] = {currY, currY + 25, currY + 25, currY};

        Polygon baseLeft = new Polygon(xLeft, yLeft, 4);
        components.add(baseLeft);
        
        int xsailLeft[] = {currX + 45, currX + 45, currX + 25};
        int ysailLeft[] = {currY - 40, currY - 10, currY - 10,}; 

        Polygon sailLeft = new Polygon(xsailLeft, ysailLeft, 3);
        components.add(sailLeft);

        Rect mastLeft = new Rect(currX + 45, currY - 40, 5, 40);
        components.add(mastLeft);
        break;

        case RIGHT:
        int xBase[] = {currX, currX + 25, currX + 75, currX + 100};
        int yBase[] = {currY, currY + 25, currY + 25, currY};

        Polygon base = new Polygon(xBase, yBase, 4);
        components.add(base);
        
        int xSail[] = {currX + 50, currX + 50, currX + 70};
        int ySail[] = {currY - 40, currY - 10, currY - 10,}; 

        Polygon sail = new Polygon(xSail, ySail, 3);
        components.add(sail);

        Rect mast = new Rect(currX + 45, currY - 40, 5, 40);
        components.add(mast);
        break;
        }
    }
    
    /* No need to override since we are only using two states for now */

    /*
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
    */
}
