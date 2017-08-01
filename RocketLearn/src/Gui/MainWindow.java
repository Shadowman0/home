package Gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;

public class MainWindow {
	JFrame frame = new JFrame("RocketTest");
	BodyCanvas bodyCanvas = new BodyCanvas();
	
	public MainWindow(){
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.add(bodyCanvas);
	}
	public void paint(Graphics g) {
		
//        Graphics2D g2 = (Graphics2D) g;
//        
//        g2.setPaint(Color.BLUE);
//        g2.fill(new Ellipse2D.Double(10, 300, 40, 40));

    }

}
