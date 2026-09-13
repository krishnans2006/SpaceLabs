import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;

/**
* SpaceLabs! This program simulates hypothetical and real solar systems
* <p>
* Class Main
* This is the driver class, and should be run
* Dependencies: Game, Planet, PlanetDetail, PSystem, RepaintApplet, Satelite, and SidePanel
* @author Krishan Shankar, Mohib Ahmed, Kanjonavo Sabud
* @version 1
*/


public class Main {
    /**
    * Main Method. Contains runnable code
    * @see Game
    * @see JFrame
    *@param args default param, does nothing
    */
   public static void main(String[] args) {

      JFrame frame = new JFrame("SpaceLabs"); //code to create JFrame
      frame.setSize(900, 600 ); //SetsJFrame's size
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Allows the JFrame to be closed
      frame.setContentPane(new Game()); //Initiates a Game JPanel 
      
      frame.setVisible(true); //Sets the frame visible
        
   }
}
