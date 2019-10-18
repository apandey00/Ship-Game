import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ToggleButton extends JToggleButton implements ActionListener{
    private ToggleButton tb;

    public ToggleButton (String text, boolean isSelected){
        this.setSelected(isSelected);
        addActionListener(this);
        setText(text);
    }

    public void addButton(ToggleButton tb) {
        this.tb = tb;
    }
    public void actionPerformed(ActionEvent e){
        if(this.isSelected()) {
            tb.setSelected(false);
        }
    }
}

