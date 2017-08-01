package Gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;

import Model.BodyList;

public class MainWindow {
	JFrame frame = new JFrame("RocketTest");
	private double scaling = 1;
	public BodyCanvas bodyCanvas;
	
	public MainWindow(BodyList bodyList){
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width-40, 
				Toolkit.getDefaultToolkit().getScreenSize().height-40);
		
		frame.setVisible(true);
		bodyCanvas = new BodyCanvas(bodyList,scaling);
		frame.add(bodyCanvas);
	}
	public void paint(Graphics g) {
		bodyCanvas.drawBodys(g);
    }

}
