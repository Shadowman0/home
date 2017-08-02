package Gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

import Model.BodyList;

public class MainWindow {
	JFrame frame = new JFrame("RocketTest");
	private double scaling = 1;
	public BodyCanvas bodyCanvas;
	
	public MainWindow(BodyList bodyList){
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width/2, 
				Toolkit.getDefaultToolkit().getScreenSize().height/2);
		
		frame.setVisible(true);
		bodyCanvas = new BodyCanvas(bodyList,scaling);
		frame.add(bodyCanvas);
	}
	public void paint(Graphics g) {
		bodyCanvas.drawBodys(g);
    }


}
