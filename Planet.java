
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.ImageIcon;
import java.util.*;
/**
* Planet Class. Contains functionalities to create, modify, and update Planet Objects
* @author Mohib Ahmed
* @version 1
*/
 
public class Planet{

  private String Name;
    /**
    *Image of planet
    */
  public Image image;
    /**
    *Mass of planet as ratio to Earth
    */
  public double mass; // in termns of earth mass
  /**
    *Diameter of planet as a ratio to Earth
    */
  private double diameter; // in terms of earth radius
   /**
    *value x and y are scaled by
    */
  private double zoomable = 100.00;
  /**
  * eccentricity of orbit
  */
  private double eccentricity; //fraction, between 0 and 1
  /**
  * SemiMajorAxis of planet, as a ratio to earth(or measured in AU)
  */
  private double semiMajorAxis; //in km
  /**
  * SemiMinorAxis as a ratio to earth(unused)
  */
  private double semiMinorAxis; // in km
    /**
    *Orbital Velocity of planet
    */
  public double v;

    /**
    *X coordinate of planet
    */
  public double x;
    /**
    *Y coordinate of planet
    */
  public double y;
  /**
  * directroy to name of sprite*/
  private String imageName;
  //constructors
  /**
  *No param constructor
  *creates a planet with attributes identical to Earth
  *@see ImageIcon
  *@see Image
  */
public Planet() //empty constructor initilizes the default planet, earth.
{
    mass = 1.0; 
    diameter = 1.0;
    eccentricity = 0.0167;
    semiMajorAxis = 1;
    semiMinorAxis = 1;
    v = 1;
   image = new ImageIcon("Sprite002.jpg").getImage();
}
  /**
  *Name constructor- Takes name, and creates a planet based on internal database of planets
  *@param name name of planet
  *@see JOptionPane
  *@see Image
  *@see ImageIcon
  */
public Planet(String name){ 
    //takes in planet name, and sets values accordingly
  switch(name){
    case "Mercury": //values of the planet "Mercury"
      Name = name;
      mass = 0.0553;
      diameter = 0.383;
      eccentricity = 0.2056;
      semiMajorAxis =0.387; 
      semiMinorAxis = 0.143;
      v = 47900.0 / 29800.0;
      image = new ImageIcon("Sprite005.png").getImage();
      imageName = "Sprite005.png"; 

      break;
      
      
     case "Venus": //values of the planet "Venus"
      Name = name;
      mass = 0.815;
      diameter = 0.949; 
      eccentricity =0.007;
      semiMajorAxis = 0.723;
      semiMinorAxis = 0.0;
      v =   35000.0 / 29800.0;
      image = new ImageIcon("Sprite003.png").getImage();
      imageName = "Sprite003.png";
     

      break;
      
      case "Earth": //values of the planet "Earth"
      Name = name;
      mass = 1.0; 
      diameter = 1.0;
      eccentricity = 0.017;
      semiMajorAxis = 1;
      semiMinorAxis = 1;
      v = 29800.0 / 29800.0;
      image = new ImageIcon("Sprite002.png").getImage();
      imageName = "Sprite002.png";
      
      break;
      
      case "Mars": //values of the planet "Mars"
      Name = name;
      mass = 0.107;
      diameter = 0.532;
      eccentricity =0.094;
      semiMajorAxis = 1.7;
      semiMinorAxis = 1.7;
      v = 24100.0 / 29800.0;
      image = new ImageIcon("Sprite004.png").getImage();
      imageName = "Sprite004.png";
      
      break;
      
      case "Jupiter": //values of the planet "Jupiter"
      Name = name;
      mass = 317.8;
      diameter = 11.21;
      eccentricity =0.049;
      semiMajorAxis = 5.2;
      semiMinorAxis = 0.0;
      v = 13100.0 / 29800.0;
      image = new ImageIcon("Sprite001.png").getImage();
      imageName = "Sprite001.png";
      
      break;

      case "Saturn": //values of the planet "Saturn"
      Name = name;
      mass = 95.2;
      diameter = 9.45;
      eccentricity =0.057;
      semiMajorAxis = 9.6;
      semiMinorAxis = 0.0;
       v = 9700.0 / 29800.0;
      image = new ImageIcon("Sprite007.png").getImage();
      imageName = "Sprite007.png";
     
      break;

      case "Uranus": //values of the planet "Uranus"
      Name = name;
      mass = 14.5;
      diameter = 4.01;
      eccentricity =0.046;
      semiMajorAxis = 19.2;
      semiMinorAxis = 0.0;
      v = 6800.0 / 29800.0;
      image = new ImageIcon("Sprite006.png").getImage();
      imageName = "Sprite006.png";
     
      break;

      case "Neptune": //values of the planet "Neptune"
      Name = name;
      mass = 17.1;
      diameter = 3.88;
      eccentricity =0.011;
      semiMajorAxis = 30.0; 
      semiMinorAxis = 0.0;
       v = 5400.0 / 29800.0;
      image = new ImageIcon("Sprite008.png").getImage();
      imageName = "Sprite008.png";
      
      break;

      default: //if the name isn't recognized
      Name = name;
      String imp1 = JOptionPane.showInputDialog(null, "Enter Mass as a multiple of earth");
      mass = Double.parseDouble(imp1);
      String imp11 = JOptionPane.showInputDialog(null, "Enter diameter as a multiple of earth");
      diameter = Double.parseDouble(imp11);
      String imp2 = JOptionPane.showInputDialog(null, "Enter Eccentricity");
      eccentricity = Double.parseDouble(imp2);
      String imp3 = JOptionPane.showInputDialog(null, "Enter semiMajorAxis in AU");
      semiMajorAxis = Double.parseDouble(imp3);
      semiMinorAxis = 0.0;
      String imp4 = JOptionPane.showInputDialog(null, "Enter Orbital velocity in m/s");
      v = Double.parseDouble(imp4) /  29800.0;
      if(mass < 1){
          image = new ImageIcon("SpriteDefault3.png").getImage();
          imageName = "SpriteDefault3.png";
      }else if(mass < 10){
          image =  new ImageIcon("SpriteDefault2.png").getImage();
          imageName = "SpriteDefault2.png";
      }else{
           image = new ImageIcon("SpriteDefault1.png").getImage();
           imageName = "SpriteDefault1.png";
      }
     
      break;



  }

}
/**
*Constructer with all attributes of a planet
*@param n name of the planet
*@param m mass of planet, as a ratio to earth
*@param e eccentricity of orbit
*@param sMGA semi-major axis, as a ratio to earth
*@param vel orbital velocity or planet
*@param s String directory of Sprite001
*/
public Planet(String n, double m, double e, double sMGA, double vel, String s){ //initilizes, given all values
  Name = n;
  mass = m;
  eccentricity = e;
  semiMajorAxis = sMGA;
  v = vel;
  imageName = s;
  image = new ImageIcon(s).getImage();
}

//Methods

//getters

/**
*@return name of planet
*/
public String getName(){
    return Name;
}
/**
*get the mass of the planet as a ratio to earth
*@return mass of planet
*/
public double getMass(){
  return mass;
}
/**
*get the diameter of the planet as a ratio to earth
*@return diameter of planet
*/
public double getDiameter(){
  return diameter;
}
/**
*get the eccentricity  
*@return eccentricity of planet
*/
public double getEccentricity(){
  return eccentricity;
}
/**
*get semi major axis as a ratio to earth
*@return semi major axis of planet
*/
public double getSemiMajorAxis(){
  return semiMajorAxis;
}
/**
*get the radius
*@return radius of planet
*/
public double getRadius(){
    return diameter / 2.0;
}
/**
*get the direcroty of the image
*@return name of image thats sprite
*/
public String getImage(){
    return imageName;
}

//setters
/**
*sets the name of the planet to the given String
*@param n name of planet
*/
public void setName(String n){
    Name = n;
}
/**
*sets the mass of the planet to the given double
*@param m mass of planet as a ratio to earth
*/
public void setMass(double m){
  mass = m;
}
/**
*sets the diameter of the planet to the given double
*@param s diameter of planet as a ratio to earth
*/
public void setDiameter(double s){
  diameter = s;
}
/**
*sets the eccentricity of the planet to the given double
*@param e eccentricity of planet
*/
public void setEccentricity(double e){
  eccentricity = e;
}
/**
*sets the semimajor axis of the planet to the given double
*@param m semimajor axis of the planet in AU
*/
public void setSemiMajorAxis(double m){
  semiMajorAxis = m;
}


//others

/**
*Sets X and Y to the next location, using the paramatric definaition of an ellipse
*@param t the time
*/
public void refresh(double t){
   //calculate orbital velocity m/s



  double a = semiMajorAxis;
  //ecentricity = c/a; c = a*ecentricity
  double c = eccentricity*a;

  double b = Math.sqrt((a*a) - (c*c));
  //calculate equation of ellipse, parametrically. Make semiMajorAxis : a and semiMinorAxis : b
  x = a*Math.cos((t*v)/(2.0*Math.PI)); // calculates x coordinate
  y = b*Math.sin((t*v)/ (2.0*Math.PI)) ; // calculates y coordinate
  //the above calculates the x and y coordinates of the orbit, centered at 0,0. 
  //However, we want it centered at the sun for visual purposes. This can be acheived by
  //calculating a,b,and c in the equation, and subtracting c to the x value. 
 x -= c;

  x = x * zoomable;
  y = y * zoomable;


}
/**
*Sets the factor by whicb the x and y are scalled
*@param zoom zoom factor
*/

public void setZoom(int zoom){
zoomable = (double)zoom;
}
}