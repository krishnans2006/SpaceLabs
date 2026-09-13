
//an array of planets
import java.util.*;
import java.io.*;

/**
* PSystem Class is the connnector between the main applet and the Planets Class
* which contains all the information regarding each planet 
* (look in Planet Class to se specifics).
* PSystem Class has speciic public methods which allow the RepaintApplet to efficiently use
* the data stored in the Planet Class
* @author Mohib Ahmed
* @version 1
*/ 

public class PSystem{
   /**
   * Creates an Array of Planets
   */ 
   private ArrayList<Planet> arr;

   //constructors
   /**
   * No Parameter Constructor which creates an empty list of planet
   */
   public PSystem(){
      arr = new ArrayList<Planet>();
   }
   /**
   * Planet Array parameter Constructor.
   * @param list  Takes in a list of Planet and adds it to an Array of Planets
   */ 
   public PSystem(Planet[] list){
      arr = new ArrayList<Planet>(list.length);
      for(int i = 0; i < list.length; i++ ){
         arr.add(list[i]);
      }
   }
//get the array
   /**
   * Copies the existing Array of Planets and returns it
   * @return array  Copied version of current Array of Planets
   */ 
   public Planet[] getArr(){
      Planet[] array = new Planet[arr.size()];
      for(int i = 0; i < array.length; i++ ){
         array[i] = arr.get(i);
      }
      return array;
   }
//get a planet
   /**
   * Gets the Planet specified by the number placement in the Planet Array
   * @param i  the planets index in array, needs the planets placement in the array to return it
   * @return Planet planet  Returns the planet specified by the number or returns default planet if number is invalid
   */
   public Planet getPlanet(int i){
      if(i >= 0 && i < arr.size()){
         return arr.get(i);
      }
      return new Planet();
   }

//gets planet by name
    /**
    * Finds Planet, recognizing it by name,
    * and returns it
    * @param s Name of the planet that needs to be found 
    * @return planetNumber The planet's number in the array is returned
    */ 
    public int findPlanet(String s){
      for(int i = 0; i < arr.size(); i++){
          if(arr.get(i).getName().equals(s)){
              return i;
          }
      }
      return -1;
   }

//add a planet
   /**
   * Adds a planet to the Array of Planets
   * @param p Adds the planet, complete with all its characteristics
   * @see Planet  See Planet class for specifications on characteristics
   */
   public void add(Planet p){
      arr.add(p);
   }

//remove planet
   /**
   * Removes planet defined by the number 
   * @param n  The planets number in the array is inputted
   * @see findPlanet See this methods as this methods finds the planet's number
   */
   public void remove(int n){
       if(n == -1){
           n = getArr().length - 1;
           while(n >= 0){
               arr.remove(n);
               n--;
           }
       }else{ 
            arr.remove(n);
       }
   }
   /**
   * Refreshes the array periodically 
   * @param t  Takes in time, and updates each planet
   */
   public void update(double t){
      for(int i = 0; i < arr.size(); i++){
         arr.get(i).refresh(t);
      }
   }

   /**
   * Sets the zoom of every planet
   * @param z the scale factor used by planet class
   * @see Planet 
   */
   public void setZoomable(int z){
       for(int i = 0; i < arr.size(); i++){
         arr.get(i).setZoom(z);
      }

   }
   
}