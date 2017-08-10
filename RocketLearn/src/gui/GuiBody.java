package gui;

import java.awt.Graphics;
import java.awt.Point;

import model.Body;
import model.Vector;

public abstract class GuiBody {
	public Point position;
	public Body body;
	
	public GuiBody(Body body, double scaling) {
		super();
		this.body = body;
		setScaledPosition(body.getPosition(),scaling);		
	}


	public void setScaledPosition(Vector vector, double scaling) {
		position = vector.toPoint(scaling);
	}
	abstract void paintBody(Graphics g, double scaling);
	
}
