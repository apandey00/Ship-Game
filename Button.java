import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Button extends JButton implements ActionListener{
	private String actionMessage;

	public Button (String label, String msg){
		
		setText(label);
		addActionListener(this);

		actionMessage = msg;
	}

	public void actionPerformed(ActionEvent e){
		System.out.println(actionMessage);
	}
}

