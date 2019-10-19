/* ColorButton.java 
 * Changes BG color
 */

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.*;

public class ColorButton extends JButton implements ActionListener{
    private String actionMessage;
    private Canvas canvas;

    public ColorButton (String label, String msg, Canvas c){
        
        setText(label);
        addActionListener(this);

        actionMessage = msg;
        canvas = c;
    }

    public void actionPerformed(ActionEvent e){
        System.out.println(actionMessage);
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();

        Color randomColor = new Color(r, g, b);
        canvas.setBG(randomColor);
        canvas.repaintCall();
    }
}

