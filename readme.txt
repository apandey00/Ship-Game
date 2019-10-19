README
Aryan Pandey
Assignment 5
Date: 10/18/2019

Notes:
- addButton currently takes too many parameters: rethink design\
- Rethink better way to handle speed functionality 
- Change start and stop buttons to toggle buttons as well



Main Changes from Assignment 4:
- Implemented a Speedboat subclass of Vehicle
- Disabled UP and DOWN states for vehicles: looked clunky 
        - rethink design and reuse state when adding vertical motion
- Added a Speedboat subclass for Vehicle
- Added toggle buttons to switch between subclasses
- Added Text fields for value input during manual ship addition
- Add ship button now can post ships of specified types at specified location
- Added a Start all and Stop all button that starts and halts animation
  of the entire simulation at once 
- Added speed control through Scrollbar


Application design description:
-   My application will simulate ships sailing in the ocean and implement some sort of control system
    The main drawing canvas will be in the center of the display and will showcase ships moving about.
-   The control panel will be at the bottom of the window. It contains buttons Left and Right that change the
    orientation of the boat and buttons that dictate start and stop. 

    Start and Stop will control the movement of the ship objects, causing them to either start moving forward or stop:

    Left and Right will rotate the ship accordingly and have already been implemented.
    
-   addShip button that adds another ship to the canvas that is controllable
     
-   To control the multiple ships on the Canvas, there is currently a ComboBox on the Right panel that toggles 
    between the ships being controlled. I might possibly change the ComboBox into multiple Radio Buttons in the
    future.

An outline showing the inheritance hierarchy:
-   ToggleButton.java mcButton.java, addButton.java, ColorButton.java 
    and rotateButton.java all have a button class that inherits from JButton
-   ScrollBar inherits from JScrollBar
-   ToggleButton inherits from JToggleButton
-   Canvas.java currently inherits from JPanel
-   Main.java inherits from JFrame
-   ComboBox.java inherits from JComboBox
-   Rect.java and Polygon.java both inherit from Shape.java
-   Sailboat.java and SpeedBoat.java both inherit from Vehicle.java

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


An outline showing the inheritance hierarchy
An outline showing the aggregation hierarchy (which objects contain or own which other objects)
New: A list showing uses or collaboration relationships (which objects use which other objects to perform functions)
New: The information hiding secrets of each of your classes (i.e., what design decisions are entirely encapsulated within that class).