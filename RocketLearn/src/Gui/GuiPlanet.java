package Gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import Model.Vector;

class GuiPlanet extends JPanel {
	public Point position;
	private int radius;
	
	public Point transformVector(Vector vector, double scaling) {
		Point result = new Point();
		result.setLocation(vector.value[0]*scaling,vector.value[1]*scaling);
		return result;
	}
	public void setScaledPosition(Vector vector, double radius, double scaling) {
		position = transformVector(vector, scaling);
		radius = Math.round(scaling*radius);
	}
	
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(Color.BLACK);
        Ellipse2D.Double kreis = new Ellipse2D.Double(position.x-radius, position.y-radius, 2*radius, 2*radius);
        g2d.draw(kreis);
    }
} 