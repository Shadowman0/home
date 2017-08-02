package Gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import Model.Body;
import Model.Planet;
import Model.Vector;

public class GuiPlanet extends GuiBody{
	private int radius;
	
	
	public GuiPlanet(Planet planet, double scaling) {
		super(planet,scaling);
		setScaledPosition(planet.getPosition(), planet.getRadius(), scaling);
	}
	public void setScaledPosition(Vector vector, double radius, double scaling) {
		super.setScaledPosition(vector, scaling);
		this.radius = (int) Math.round(scaling*radius);
	}
	@Override
    public void paintBody(Graphics g, double scaling) {
    	Graphics2D g2 = (Graphics2D) g;
    	setScaledPosition(body.getPosition(), ((Planet)body).getRadius(), scaling);
        g2.setPaint(Color.BLUE);
//        g2.fillRect(position.x, position.y, 10, 10);
        g2.fillOval(position.x-radius, position.y-radius, radius*2, radius*2);
//        System.out.println(radius);
    }
} 