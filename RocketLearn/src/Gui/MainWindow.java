package Gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;

public class MainWindow {
	JFrame frame = new JFrame("RocketTest");
	public BodyCanvas bodyCanvas = new BodyCanvas();
	
	public MainWindow(){
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, 
				Toolkit.getDefaultToolkit().getScreenSize().height);
		
		frame.setVisible(true);
		frame.add(bodyCanvas);
	}
	public void paint(Graphics g) {
		bodyCanvas.drawBodys(g);
		
//        Graphics2D g2 = (Graphics2D) g;
//        
//        g2.setPaint(Color.BLUE);
//        g2.fill(new Ellipse2D.Double(10, 300, 40, 40));

    }

}
