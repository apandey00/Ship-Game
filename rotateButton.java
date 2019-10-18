// rotateButton.java
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class rotateButton extends JButton implements ActionListener{
    private String actionMessage;
    private String rotate;
    private Model model;

    public rotateButton (String label, String msg, String rot, Model m){
        
        setText(label);
        addActionListener(this);

        actionMessage = msg;
        rotate = rot;
        model = m;
    }

    public void actionPerformed(ActionEvent e){
        System.out.println(actionMessage);
        if (rotate == "Left") {
            (model.getVehicles(model.getCurVehicle())).rotateLeft();
        }
        if (rotate == "Right") {
            (model.getVehicles(model.getCurVehicle())).rotateRight();
        }
        model.redraw();
    }
}

