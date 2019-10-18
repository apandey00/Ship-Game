/* Main.java */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Main extends JFrame {
    public static void main (String [] args){
        java.awt.EventQueue.invokeLater( new Runnable(){
            public void run(){
                new Main();
            }
        });
    }
    public Main(){
         setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
         setSize(1000, 600);
         setTitle("Ship Traffic Simulator");
         
        
        SpeedBoat boat = new SpeedBoat(200,200);

        /* Holds data for simulation */
        Model dataModel = new Model(boat);
         ScrollBar sBar = new ScrollBar(dataModel);
        /* Main drawing area */
        Canvas canvas = new Canvas(dataModel);
        add (canvas, BorderLayout.CENTER);

        dataModel.setCanvas(canvas);
        
        /* Ships panel on right
         * Keeps track of controllable ships 
         */
        JPanel Ships = new JPanel ();
        Ships.setBorder (new LineBorder(Color.BLUE, 2));
        Ships.setLayout (new GridLayout (5, 1));

        // Put these inside the Ships panel
        JLabel label = new JLabel ("Ships:");
        Ships.add (label);
        String[] comboStrings = { "Ship 1"};
        ComboBox combo = new ComboBox(comboStrings, dataModel, sBar);
        Ships.add (combo);

        // Background color button
        ColorButton colorB = new ColorButton("Change Color", "color changed", canvas);
        Ships.add(colorB);

       
        // Start and Stop buttons
        mcButton startAllButton = new mcButton ("Start All", "Start All was pressed", "startAll", dataModel, sBar);
        Ships.add (startAllButton);
        mcButton stopAllButton = new mcButton ("Stop All", "Stop All was pressed", "stopAll", dataModel, sBar);
        Ships.add (stopAllButton);
        
        // Adding to Mainframe
        add (Ships, BorderLayout.EAST);
         
        // Control panel at bottom
	    JPanel controls = new JPanel ();
	    controls.setBorder (new LineBorder(Color.BLUE, 2));
        controls.setLayout (new FlowLayout ());
        
        // Components inside Control Panel
        
        // Buttons that handle rotations
        rotateButton rleftButton = new rotateButton("Left", "Rotate Left", "Left", dataModel);
        controls.add(rleftButton);
        rotateButton rrightButton = new rotateButton("Right", "Rotate Right", "Right", dataModel);
        controls.add(rrightButton);

        // Start and Stop buttons
        mcButton startButton = new mcButton ("Start", "Start was pressed", "start", dataModel, sBar);
        controls.add (startButton);
        mcButton stopButton = new mcButton ("Stop", "Stop was pressed", "stop", dataModel, sBar);
        controls.add (stopButton);


        // radiobuttons
        ToggleButton tb1 = new ToggleButton("Sailboat", true);
        ToggleButton tb2 = new ToggleButton("Speedboat", false);
        tb1.addButton(tb2);
        tb2.addButton(tb1);

        controls.add(tb1);
        controls.add(tb2);

        // Add Ship Button
        TextField tfCol = new TextField();
        TextField tfRow = new TextField();
        controls.add(tfCol);
        controls.add(tfRow);

        
        addButton addB = new addButton ("Add Ship", "New Ship Added", dataModel, 
                                        combo, tfCol, tfRow);
        controls.add (addB);

        // Speed control

        controls.add(sBar);
        
        // Adding to main panel 
        add (controls, BorderLayout.SOUTH);        

        setVisible(true);
    }
}