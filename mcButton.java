/* mcButton.java
 */ Button for Motion Control
 */
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mcButton extends JButton implements ActionListener{
    private String actionMessage;
    private String motion;
    private Model model;
    private ScrollBar scBar;

    public mcButton (String label, String msg, String motion, Model m, ScrollBar scBar){
        
        setText(label);
        addActionListener(this);

        actionMessage = msg;
        this.motion = motion;
        model = m;
        this.scBar = scBar;
    }

    public void actionPerformed(ActionEvent e){
        System.out.println(actionMessage);
        if (motion == "start") {
            model.startCurr();
            scBar.setEnabled(true);
        }
        if (motion == "stop") {
            model.stopCurr();
            scBar.setEnabled(false);
            
        }
        if (motion == "startAll") {
            model.startAll();;
            scBar.setEnabled(true);
        }
        if (motion == "stopAll") {
            model.stopAll();
            scBar.setEnabled(false);
        }
        model.redraw();
    }
}

