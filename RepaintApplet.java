
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.io.File;  // Import the File class
import java.io.FileWriter;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.*;


/**
 *<applet code ="RepaintApplet" width=300 height=50>
 *</applet>
 *This applet displays the Sidepanel, Graphical Simulation and calls to PSystem, Planets, and PlanetsDetail to make teh simulation work
 *@author Mohib Ahmed
 * @see Planets
 * @see PlanetsDetail
 * @see PSystem
 * @see SidePanel
 */
public class RepaintApplet extends JApplet implements Runnable{

    /**
    *thread is createdhere so it can be accessed by other classes
    */
   Thread t = null;
    /**
    *boolean constant used to end the thread
    */
   boolean stopFlag;
   /**
   * internal time
   */
   double time = 0;
   /**
   * System of planets to display
   *@see PSystem
   */
   public PSystem system = new PSystem(); 

   /**
   * planet detail object for display
   *@see PlanetsDetail
   */
   public PlanetsDetail pd = new PlanetsDetail();
   /**
   * creates an array of labels.
   */
   public JLabel arr[];
   /**
   * instantiates the SidePanel Object which contains all buttons
   */
   public SidePanel sp;
   
   /**
   *  Initiates the repaint applet
   * @see JPanel, JOptionPane, PSystem, Planet
   */
   public RepaintApplet()
   {
       
      setLayout(new BorderLayout());
      setBackground(Color.BLACK); // To set Background color of an Applet
      // To set Foreground color of an Applet
      getContentPane().setBackground(Color.BLACK);
      String imp = "";
      sp = new SidePanel();
      add(sp, BorderLayout.EAST);
      while (imp.equals("end") == false){
         imp = JOptionPane.showInputDialog(null, "Which Planets do you want to add?(Enter \"end\" to finish or \"def\" for default)"); 
         if(imp.equals("def")){
             system.add(new Planet("Mercury"));
             system.add(new Planet("Venus"));
             system.add(new Planet("Earth"));
             system.add(new Planet("Mars"));
             system.add(new Planet("Jupiter"));
             system.add(new Planet("Saturn"));
             system.add(new Planet("Uranus"));
             system.add(new Planet("Neptune"));
             break;
         }
         if(!imp.equals("end")){
            system.add(new Planet(imp)); 
         }
      
      }
      
      arr = new JLabel[system.getArr().length];
   }
   /**
   * starts thread and initiates the simulation
   * @see thread
   */
   public void start ()
   {
      t = new Thread (this);
      stopFlag = false;
      t.start();
   }
   /**
   * Code that is run in a loop, the simulation
   * @author Ahmed Mohib
   * @author Kanjonavo Sabud
   * @author Krishnan Shankar
   * @see Exception
   * @see Thread
   * @see PSystem
   * @see Planet
   * @see SidePanel
   * @see PlanetsDetail
   */
   public void run ()
   {

      for (;;)
      {
        setBackground(Color.BLACK);
         try{
            time += 1;
            repaint ();
         
            Thread.sleep(sp.tRatio);
            
            system.setZoomable((int)((double)sp.tZoom*0.8));
            
            if(sp.isDetail == true){
                String imp = JOptionPane.showInputDialog(null, ("Which Planet's details do you want to see?" + "\n" + "(Enter \"end\" to cancel)"));
                if(!imp.equals("end")){
                    pd.showDetails(imp);
                }
                sp.resetDetail();
            }
            if(sp.isAdd == true){
                String imp = JOptionPane.showInputDialog(null, "Name of your planet?" + "\n" + "Type \" end \" to cancel");
                if(!imp.equals("end")){
                    system.add(new Planet(imp)); 
                }
                sp.resetAdd();

            }
            if(sp.isPause == true){
                for(;;){
                    Thread.sleep(100);
                    if(sp.isRun == true ){
                        sp.resetPause();
                        this.run();
                        break;
                    } 
                }
            }

            if(sp.isDelete == true){
                String imp = JOptionPane.showInputDialog(null, "Which planet to delete? (Enter name)");
                try{
                    for(int i = 0; i < system.getArr().length; i++){
                        if(system.getPlanet(i).getName().equals(imp)){
                            system.remove(i);
                        }
                    }
                }catch(Exception e){
                    sp.resetDelete();
                }
                sp.resetDelete();
            }
            
            if(sp.isRest == true){
                system.remove(-1);
                system.add(new Planet("Mercury"));
                system.add(new Planet("Venus"));
                system.add(new Planet("Earth"));
                system.add(new Planet("Mars"));
                system.add(new Planet("Jupiter"));
                system.add(new Planet("Saturn"));
                system.add(new Planet("Uranus"));
                system.add(new Planet("Neptune"));
                
                sp.resetRes();

            }
            
            if(sp.isSave == true){
                sp.resetSave();
                File filea = new File("savechanges_SPACELABS.txt");
                filea.delete();
                File file = new File("savechanges_SPACELABS.txt");
                file.delete();
        
                FileWriter writer = new FileWriter("savechanges_SPACELABS.txt");
                String temp = "";
                for(int i = 0; i < system.getArr().length; i++ ){
                    temp = system.getPlanet(i).getName() + " " + system.getPlanet(i).getMass() + " " + system.getPlanet(i).getSemiMajorAxis() + " " + system.getPlanet(i).getEccentricity() + " " + system.getPlanet(i).v + " " +system.getPlanet(i).getImage();
                    writer.write(temp);
                    writer.write("\n");
                }
                writer.close();
                    
            }
            if(sp.isLoad == true){
                sp.resetLoad();
                system.remove(-1);
                File file = new File("savechanges_SPACELABS.txt");
                Scanner reader = new Scanner(file);
                      while (reader.hasNextLine()) {
                            String data[] = reader.nextLine().split(" ");
                            String na = data[0];
                            Double ma = Double.parseDouble(data[1]);
                            Double sm = Double.parseDouble(data[2]);
                            Double ec = Double.parseDouble(data[3]);
                            Double ve = Double.parseDouble(data[4]);
                            String s = data[5];
                            system.add(new Planet(na, ma, ec, sm, ve, s));
                        }
                    reader.close();
                
            }

         }catch (Exception e){
         //nothing
         }
      }
   
   }
   /**
   * Code to stop the simulation
   */
   public void stop ()
   {
      stopFlag = true;
      t = null;
     
      
   }
   /**
   *Code to draw the planets at each interval
   *@see Graphics, ImageIcon, PSystem, Planet, Satelite
   */
   public void paint (Graphics g)
   {
      super.paint(g);
           
      system.update(time); 
      g.drawImage(new ImageIcon("SpriteStar2.png").getImage(), (int)( (double) getWidth() * 0.5)-25 - 150, (int)( (double) getHeight() * 0.5)-25,this);
      for(int i = 0; i < system.getArr().length; i++){
         int x = (int)system.getPlanet(i).x  + (int)( (double) getWidth() * 0.5) - 150;
         int y = (int)system.getPlanet(i).y  + (int)( (double) getHeight() * 0.5);
         
         if(x <= 565){
            g.drawImage(system.getPlanet(i).image, x, y,this);
        }      
    }
}
}