package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class BodyCanvas extends JFrame {
    
    JPanel panel;
    
    public BodyCanvas(){
    	panel = new GuiPlanet();
        add(panel);

        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    } 
}