
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
* Instantiates the buttons and initiates them using variouse action listeners
* @author Krishnan Shankar
*/
public class SidePanel extends JPanel {

   /**
   * boolean for New Planet button
   */
   public boolean isAdd = false;
   /**
   * boolean for Planet Details button
   */
   public boolean isDetail = false;
   /**
   * boolean for Delete button
   */
   public boolean isDelete = false;
   /**
   * boolean for Run button
   */
   public boolean isRun = false;
   /**
   * boolean for Pause button
   */
   public boolean isPause = false;
   /**
   * boolean for Reset Simulation button
   */
   public boolean isRest = false;
   /**
   * boolean for Load Configurations button
   */
   public boolean isLoad = false;
   /**
   * boolean for Save Configurations button
   */
   public boolean isSave = false;
   /**
   * ??
   */
   public int tRatio = 100;
   /**
   * ?? 
   */
   public int tZoom = 10;
   /**
   * instantiates zoomIn button
   */
   private JButton zoomIn;
   /**
   * instantiates zoomOut button
   */
   private JButton zoomOut;
   /**
   * instantiates music button
   */
   private JButton music;

   /**
   * Constructor for a sidepanel object for use in repaint applet
   */
   public SidePanel() {
      BorderLayout bl = new BorderLayout();
      bl.setVgap(7);
   
      setLayout(bl);
      setBackground(Color.BLACK);

      JPanel east = new JPanel();
      east.setLayout(new GridLayout(15,1));
   
      JButton info = new JButton("Planet Details");
      info.addActionListener(new DetailListener());
      east.add(info);
   
      east.add(new JLabel(""));
        
      JButton insert = new JButton("New Planet");
      insert.addActionListener(new InsertListener());
      east.add(insert);
   	
      JButton delete = new JButton("Delete Planet");
      delete.addActionListener(new DeleteListener());
   	//delete.setEnabled(false);
      east.add(delete);
   
      east.add(new JLabel(""));
   	
      JButton run = new JButton("Run Simulation");
      run.addActionListener(new RunListener());
        //pause.setEnabled(true);
      east.add(run);
   	
      JButton pause = new JButton("Pause Simulation");
      pause.addActionListener(new PauseListener());
    	//pause.setEnabled(true);
      east.add(pause);
   
      JButton reset = new JButton("Reset Simulation");
      reset.addActionListener(new ResetListener());
      east.add(reset);
   
      east.add(new JLabel(""));
   
      JButton save = new JButton("Save Configurations");
      save.addActionListener(new SaveListener());
      east.add(save);
   
      JButton load = new JButton("Load Configurations");
      load.addActionListener(new LoadListener());
      east.add(load);
   
      JLabel speedDesc = new JLabel("  Set Speed of Simulation");
      east.add(speedDesc);
   
      JSlider speed = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);
      Font font = new Font("Serif", Font.ITALIC, 15);
      speed.setFont(font);
      speed.setMajorTickSpacing(2);
      speed.setMinorTickSpacing(1);
      speed.setPaintTicks(true);
      speed.setPaintLabels(true);
      speed.addChangeListener(new OnSpeedChange());
      east.add(speed);
   
   
      JLabel zoomer = new JLabel("   Zoom in and out");
      east.add(zoomer);
        
      JPanel zoomButtons = new JPanel();
      zoomButtons.setLayout(new GridLayout(1, 7));
   
      for (int i = 0; i < 2; i++) {
         zoomButtons.add(new JLabel(""));
      }
   
      zoomIn = new JButton("+");
      zoomIn.addActionListener(new zoomInListener());
      zoomButtons.add(zoomIn);
   
      zoomButtons.add(new JLabel(""));
   
      zoomOut = new JButton("-");
      zoomOut.addActionListener(new zoomOutListener());
      zoomButtons.add(zoomOut);
   
      for (int i = 0; i < 2; i++) {
         zoomButtons.add(new JLabel(""));
      }
   
      east.add(zoomButtons);

   
      add(east,BorderLayout.EAST);
   }
   /**
   * sets isDetail boolean to false
   */
   public void resetDetail(){
      isDetail = false;
   }
   /**
   * sets isAdd boolean to false
   */
   public void resetAdd(){
      isAdd = false;
   }
   /**
   * sets isPause and isRun boolean to false
   */
   public void resetPause(){
      isPause = false;
      isRun = false;
   }
   /**
   * sets isDelete boolean to false
   */
   public void resetDelete(){
      isDelete = false;
   }
   /**
   * sets isRest boolean to false
   */
   public void resetRes(){
      isRest = false;
   }
   /**
   * sets isLoad boolean to false
   */
   public void resetLoad(){
      isLoad = false;
   }
   /**
   * sets isSave boolean to false
   */
   public void resetSave(){
      isSave = false;
   }
   

   /**
   *Tells the Applet to provide planet details on the next tick
   */ 
   private class DetailListener implements ActionListener {
       /**
       *@param e the event the listner waits for
       */
      public void actionPerformed(ActionEvent e) {
         isDetail = true;
      }
   }
   /**
   *Tells the Applet to provide the planet inserting prompt on the next tick
   */
   private class InsertListener implements ActionListener {
       /**
       *@param e the event the listner waits for
       */
      public void actionPerformed(ActionEvent e) {
         isAdd = true;
      }
   }
   /**
   *Tells the Applet to provide the delete planet dialog on the next tick
   */
   private class DeleteListener implements ActionListener {
       /**
       *@param e the event the listner waits for
       */
      public void actionPerformed(ActionEvent e) {
         isDelete = true;
      }
   }
   /**
   *Tells the Applet to start the simulation on the next tick
   */
   private class RunListener implements ActionListener {
       /**
       *@param e the event the listner waits for
       */
      public void actionPerformed(ActionEvent e) {
         isRun = true;
      }
   }
   /**
   *Tells the Applet to pause the simulation on the next tick
   */
   private class PauseListener implements ActionListener {
       /**
       *@param e the event the listner waits for
       */
      public void actionPerformed(ActionEvent e) {
         isPause = true;
      }
   }
   /**
   *Tells the Applet to Reset the simulation on the next tick
   */
   private class ResetListener implements ActionListener {
       /**
       *@param e the event the listner waits for
       */
      public void actionPerformed(ActionEvent e) {
         isRest = true;
            // resets
      }
   }
   /**
   *Tells the Applet to save the configurations on the next tick
   */
   private class SaveListener implements ActionListener {
       /**
       *@param e the event the listner waits for
       */
      public void actionPerformed(ActionEvent e) {
         isSave = true;
      	// Saves the simulation and variables in a .txt file to access later
      }
   }
   /**
   *Tells the Applet to load the configurations on the next tick
   */
   private class LoadListener implements ActionListener {
       /**
       *@param  e the event the listner waits for
       */
      public void actionPerformed(ActionEvent e) {
         isLoad = true;
      	// loads the simulation and variables in a .txt file to access later
      }
   }
   /**
   *Tells the Applet to update the speed of the simulation on the next tick
   */
   private class OnSpeedChange implements ChangeListener {
       /**
       *@param  e the event the listner waits for
       */
      public void stateChanged(ChangeEvent e) {
         JSlider slider = (JSlider) e.getSource();
         if (!slider.getValueIsAdjusting()) {
            int value = slider.getValue();
            tRatio = 1000 / (value*value) ;
         }
      }
   }
   /**
   *Tells the Applet to increase the zoom value on the next tick
   */
   private class zoomInListener implements ActionListener {
       /**
       *@param  e the event the listner waits for
       */
      public void actionPerformed(ActionEvent e) {
         tZoom += 10;
         if (tZoom > 90) {
            tZoom = 100;
            zoomIn.setEnabled(false);
            zoomOut.setEnabled(true);
         } else if (tZoom < 20) {
            tZoom = 10;
            zoomOut.setEnabled(false);
            zoomIn.setEnabled(true);
         } else {
            zoomIn.setEnabled(true);
            zoomOut.setEnabled(true);
         }
            
      	
      }
   }
   /**
   *Tells the Applet to decrease the zoom value on the next tick
   */
   private class zoomOutListener implements ActionListener {
       /**
       *@param  e the event the listner waits for
       */
      public void actionPerformed(ActionEvent e) {
         tZoom -= 10;
         if (tZoom > 130) {
            tZoom = 100;
            zoomIn.setEnabled(false);
            zoomOut.setEnabled(true);
         } else if (tZoom < 20) {
            tZoom = 10;
            zoomOut.setEnabled(false);
            zoomIn.setEnabled(true);
         } else {
            zoomIn.setEnabled(true);
            zoomOut.setEnabled(true);
         }
            
            
      }
   }

}