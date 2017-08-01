package Gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BodyCanvas extends JPanel{
	List<GuiPlanet> planets = new ArrayList<>();
	
	
	public void paint(Graphics g) {
		for (GuiPlanet guiPlanet : planets) {
			guiPlanet.paintComponent(g);
		}

//        Graphics2D g2 = (Graphics2D) g;
//
//        g2.setPaint(Color.RED);
//        g2.setStroke(new BasicStroke(5.0f));
//        g2.draw(new Ellipse2D.Double(50, 50, 250, 250));
//
//        g2.setPaint(Color.BLUE);
//        g2.fill(new Ellipse2D.Double(10, 10, 40, 40));
//
//        g2.setPaint(Color.YELLOW);
//        g2.fill(new Ellipse2D.Double(10, 300, 40, 40));
//
//        g2.setPaint(Color.GREEN);
//        g2.fill(new Ellipse2D.Double(300, 300, 40, 40));
//
//        g2.setPaint(Color.ORANGE);
//        g2.fill(new Ellipse2D.Double(300, 10, 40, 40));
    }
	
    GuiPlanet planet;
    
    public BodyCanvas(){
    	planet = new GuiPlanet(new Point(100,100),20);
    	planets.add(planet);
    } 
}