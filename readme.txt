README
Aryan Pandey
Assignment 5
Date: 10/18/2019

Main Changes from Assignment 4:
- Implemented a Speedboat subclass of Vehicle

Main Changes from Assignment 3:
- Implemented drawing ships with Java draw methods instead of ImageIcons
- Added Shape superclass with Rect and Polygon subclasses
- Ships are essentially rendered out as a combination of shapes
- Ships that are drawn can still be rotated with the rotate buttons
- Add ship functionality now works
- Color Change Button implemented - Changes BG color to a random color
- ComboBox is properly implemented: now switches program control to appropriate ships accordingly
- Added Sailboat class that inherits from the Vehicle superclass
- Added Model class that keeps track of simulation data and stores all vehicles


Application design description:
-   My application will simulate ships sailing in the ocean and implement some sort of control system
    The main drawing canvas will be in the center of the display and will showcase ships moving about.
-   The control panel will be at the bottom of the window. It contains buttons Left and Right that change the
    orientation of the boat and buttons that dictate start and stop. 

    Start and Stop will control the movement of the ship objects, causing them to either start moving forward or stop:
    Yet to be implemented.

    Left and Right will rotate the ship accordingly and have already been implemented.
    
-   addShip button that adds another ship to the canvas that is controllable
    has now been implemented
     
-   To control the multiple ships on the Canvas, there is currently a ComboBox on the Right panel that toggles 
    between the ships being controlled. I might possibly change the ComboBox into multiple Radio Buttons in the
    future.

An outline showing the inheritance hierarchy:
-   Button.java, addButton.java, ColorButton.java and rotateButton.java all 
    have a button class that inherits from JButton
-   Canvas.java currently inherits from JPanel
-   Main.java inherits from JFrame
-   ComboBox.java inherits from JComboBox
-   Rect.java and Polygon.java both inherit from Shape.java
-   Sailboat.java inherits from Vehicle.java

An outline showing the aggregation hierarchy:
-   The Main window in Main.java starts off with a Panel in BorderLayout format
    It contains the following:
    The CENTER space is occupied by the Canvas (drawing area)
        Canvas class has an instance of the Model class 
        The Model class holds all data for the simulation
        and the canvas class uses this for drawing to display

    The SOUTH space is occupied  by a a JPanel called controls
        controls contains:
        Two buttons Start and Stop that will handle image animation
        Two rotateButtons that rotate images accordingly
         - these buttons have access to the canvas to call repaint
        An Addship button that adds another controllable object to the
        simulation. It contains a pointer to the model to update ship
        information and redraw.

    The EAST space is occupied by a JPanel currently called ships
        It contains a ComboBox that will toggle control of ships in
        the canvas. Combobox contains a pointer to the Model class 
        to update data.
        It also contains a ColorButton that changes BG color when clicked.
        ColorButton contains a pointer to the Canvas for redraw calls


    The Model class has a vector of Vehicles and a pointer to the canvas
    incase it needs to redraw.

    The Vehicle class has a vector of Shapes that essentially make up
    a "vehicle"

    The SailBoat subclass has two instances of Polygon objects as well
    as a Rect object to represent itself.


Compile with: javac Main.java
Run with: java Main


